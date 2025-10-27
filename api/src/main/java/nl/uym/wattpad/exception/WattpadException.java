package nl.uym.wattpad.exception;

import org.springframework.http.HttpStatusCode;

import lombok.ToString;

/**
 * Custom RuntimeException for any Wattpad API exception.
 *
 * @author Yaris van Thiel
 */
@ToString
public class WattpadException extends RuntimeException {

	public WattpadException(HttpStatusCode statusCode, String message) {
		super(String.format("HTTP %s: %s", statusCode.value(), message));
	}
}
