package nl.uym.wattpad;

import nl.uym.wattpad.dto.WattpadStories;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

/**
 * @author Yaris van Thiel
 */
@Service
@RequiredArgsConstructor
public final class WattpadAPI {

	private static final short OFFSET = 0;
	private static final short LIMIT = 25;
	private static final String STORY_FIELDS = "stories(title,voteCount,readCount,commentCount,cover,url,id,description,numParts,parts),total,nextUrl,numPublished,numDrafts";

	private final WebClient webClient;

	public WattpadStories getStories() {
		return webClient
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
		        .bodyToMono(WattpadStories.class)
		        .block();

	}

}
