package nl.uym.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Spring Security configuration grouping production and Swagger-specific setups.
 *
 * @author Yaris van Thiel
 */
@Configuration
public class SecurityConfig {

	/**
	 * Security configuration used in production/runtime profiles (excluding test and swagger). Configures CORS,
	 * disables CSRF, and permits all requests while allowing method security.
	 */
	@Profile("!test & !swagger")
	@Configuration
	@EnableMethodSecurity(prePostEnabled = false, jsr250Enabled = true)
	public static class ProductionConfig {

		/**
		 * Configures the security filter chain for production-like profiles.
		 *
		 * @param http HttpSecurity builder
		 * @return the configured SecurityFilterChain
		 * @throws Exception if the chain cannot be built
		 */
		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http
			        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
			        .csrf(AbstractHttpConfigurer::disable)
			        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
			        .authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			        .build();
		}

		/**
		 * Defines a permissive CORS configuration for local development hosts.
		 *
		 * @return a CorsConfigurationSource registering allowed origins, methods and headers
		 */
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			final CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(List.of("http://localhost:4200"));
			configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
			configuration.setAllowedHeaders(List.of("authorization", "content-type", "x-auth-token"));
			configuration.setExposedHeaders(List.of("x-auth-token"));
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}

	/**
	 * Security configuration used when running the Swagger UI profile. Permits all requests and disables CSRF for ease
	 * of documentation access.
	 */
	@Configuration
	@Profile("swagger")
	@EnableMethodSecurity(prePostEnabled = false, jsr250Enabled = true)
	public static class SwaggerConfig {

		/**
		 * Configures an all-permit security filter chain for the Swagger profile.
		 *
		 * @param http HttpSecurity builder
		 * @return the configured SecurityFilterChain
		 * @throws Exception if the chain cannot be built
		 */
		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http
			        .csrf(AbstractHttpConfigurer::disable)
			        .authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			        .build();
		}
	}

}
