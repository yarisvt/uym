package nl.uym.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

/**
 * @author Yaris van Thiel
 */
@Configuration
public class OpenAPIConfig {

	@Value("${info.app.version}")
	private String version;

	@Bean
	GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("uym-admin").pathsToMatch("/api/**").build();
	}

	@Bean
	OpenAPI apiInfo() {
		return new OpenAPI();
	}

}
