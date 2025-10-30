package nl.uym.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Spring configuration for the OpenAPI/Swagger documentation metadata.
 * <p>
 * Creates a singleton OpenAPI bean using application information (title, description, version) sourced from the Spring
 * configuration properties.
 * </p>
 *
 * @author Yaris van Thiel
 */
@Configuration
public class OpenAPIConfig {

	@Value("${info.app.title}")
	private String title;

	@Value("${info.app.description}")
	private String description;

	@Value("${info.app.version}")
	private String version;

	/**
	 * Builds the OpenAPI instance used by springdoc-openapi.
	 *
	 * @return configured OpenAPI descriptor
	 */
	@Bean
	OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title(title).description(description).version(version));
	}

}
