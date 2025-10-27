package nl.uym.wattpad;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

import nl.uym.wattpad.dto.WattpadStories;
import nl.uym.wattpad.exception.WattpadException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service bean for interacting with the Wattpad REST API.
 * <p>
 * This class encapsulates calls to Wattpad endpoints using a preconfigured Spring WebClient. Requests are built with
 * fixed paging defaults and a curated set of fields to minimize payload size.
 * </p>
 *
 * @author Yaris van Thiel
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WattpadAPI {

	private static final short OFFSET = 0;
	private static final short LIMIT = 25;
	private static final String STORY_FIELDS = "stories(title,voteCount,readCount,commentCount,cover,url,id,description,numParts,parts),total,nextUrl,numPublished,numDrafts";

	private final RestClient restClient;

	/**
	 * Fetches the user's published Wattpad stories using the configured WebClient.
	 *
	 * @return the WattpadStories response payload
	 */
	@Cacheable(cacheNames = "stories")
	public WattpadStories getStories() {
		try {
			return restClient
			        .get()
			        .uri(uriBuilder -> uriBuilder
			                .path("/stories")
			                .path("/published")
			                .queryParam("offset", WattpadAPI.OFFSET)
			                .queryParam("limit", WattpadAPI.LIMIT)
			                .queryParam("fields", WattpadAPI.STORY_FIELDS)
			                .build())
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .onStatus(HttpStatusCode::is4xxClientError, (_, response) -> {
				        throw new WattpadException(response.getStatusCode(),
				                new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8));
			        })
			        .body(WattpadStories.class);
		} catch (WattpadException e) {
			WattpadAPI.log.error("Error fetching stories", e);
			return WattpadStories.builder().stories(List.of()).total(0).build();
		}
	}

	/**
	 * Evicts all caches after an hour.
	 */
	@CacheEvict(allEntries = true, cacheNames = "stories")
	@Scheduled(fixedDelay = 10, timeUnit = TimeUnit.MINUTES)
	public void cacheEvict() {
	}
}
