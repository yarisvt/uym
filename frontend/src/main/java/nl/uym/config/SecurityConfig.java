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
 * @author Yaris van Thiel
 */
@Configuration
public class SecurityConfig {

	@Profile("!test & !swagger")
	@Configuration
	@EnableMethodSecurity(prePostEnabled = false, jsr250Enabled = true)
	public static class ProductionConfig {

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
		 * Globally allow acces via localhost:4200 (angular dev server)
		 *
		 * @return
		 */
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			final CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:3592"));
			configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
			configuration.setAllowedHeaders(List.of("authorization", "content-type", "x-auth-token"));
			configuration.setExposedHeaders(List.of("x-auth-token"));
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}

	@Configuration
	@Profile("swagger")
	@EnableMethodSecurity(prePostEnabled = false, jsr250Enabled = true)
	public static class SwaggerConfig {

		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http
			        .csrf(AbstractHttpConfigurer::disable)
			        .authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			        .build();
		}
	}

}
