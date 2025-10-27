package nl.uym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author Yaris van Thiel
 */
@EnableCaching
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class UYM extends SpringBootServletInitializer implements WebApplicationInitializer {

	static void main(final String[] args) {
		SpringApplication.run(UYM.class, args);
	}

}
