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

@Profile("!test & !swagger")
@Component
public class RewriteConfig extends UrlRewriteFilter {

	private static final String CONFIG_LOCATION = "classpath:/urlrewrite.xml";

	@Value(RewriteConfig.CONFIG_LOCATION)
	private Resource resource;

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
