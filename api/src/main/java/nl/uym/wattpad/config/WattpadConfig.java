package nl.uym.wattpad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;

/**
 * @author Yaris van Thiel
 */
@Configuration
public class WattpadConfig {

	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36";

	@Value("${nl.uym.wattpad.config.base-url}")
	private String baseUrl;

	/**
	 * Creates the RestClient used to communicate with the Wattpad API. Sets the base URL from configuration and a
	 * realistic User-Agent header.
	 *
	 * @return configured RestClient bean
	 */
	@Bean
	RestClient createRestClient() {
		return RestClient.builder().baseUrl(baseUrl).defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT).build();
	}
}
