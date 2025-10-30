package nl.uym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wattpad4j.api.WattpadApi;
import org.wattpad4j.api.WattpadConstants;

/**
 * @author Yaris van Thiel
 */
@Configuration
public class WattpadConfig {

	@Bean
	WattpadApi wattpadApi() {
		return new WattpadApi(WattpadConstants.BASE_URL);
	}

}
