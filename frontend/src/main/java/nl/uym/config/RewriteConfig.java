package nl.uym.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;

/**
 * URL rewrite filter configuration that loads the Tuckey UrlRewrite configuration from classpath:/urlrewrite.xml when
 * the application starts (except for the "test" and "swagger" profiles).
 *
 * @author Yaris van Thiel
 */
@Profile("!test & !swagger")
@Component
public class RewriteConfig extends UrlRewriteFilter {

	private static final String CONFIG_LOCATION = "classpath:/urlrewrite.xml";

	@Value(RewriteConfig.CONFIG_LOCATION)
	private Resource resource;

	/**
	 * Loads the UrlRewrite configuration from the configured resource and checks its validity.
	 *
	 * @param filterConfig the servlet filter configuration provided by the container
	 * @throws ServletException if the configuration cannot be read or is invalid
	 */
	@Override
	protected void loadUrlRewriter(final FilterConfig filterConfig) throws ServletException {
		try {
			final Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(),
			        resource.getFilename(), "");
			checkConf(conf);
		} catch (final IOException ex) {
			throw new ServletException(
			        "Unable to load URL-rewrite configuration file from " + RewriteConfig.CONFIG_LOCATION, ex);
		}
	}
}
