package nl.uym.wattpad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Yaris van Thiel
 */
@Configuration
public class WattpadConfig {

	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36";

	@Value("${nl.uym.wattpad.config.base-url}")
	private String baseUrl;

	@Bean
	public WebClient createWebclient() {
		return WebClient.builder()
		        .baseUrl(baseUrl)
		        .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
		        .build();

	}
}
