package nl.uym.controller;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.NoSuchElementException;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestNotUsableException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.wattpad4j.api.WattpadApiException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yaris van Thiel
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

	private ResponseEntity<String> createResponse(final HttpStatus status, final Throwable dto, final String d) {
		return createResponse(status, StringUtils.trimToNull(StringUtils.defaultIfBlank(dto.getMessage(), d)));
	}

	private <T> ResponseEntity<T> createResponse(final HttpStatus status, final T dto) {
		return new ResponseEntity<>(dto, status);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final Throwable ex) {
		ExceptionHandler.log.warn("Unhandled error", ex);
		return createResponse(HttpStatus.BAD_REQUEST, ex, "Unknown error");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ClientAbortException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final ClientAbortException ex) {
		return createResponse(HttpStatus.BAD_REQUEST, ex, "Unknown error");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(AsyncRequestNotUsableException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final AsyncRequestNotUsableException ex) {
		return createResponse(HttpStatus.BAD_REQUEST, ex, "Unknown error");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final IllegalArgumentException ex) {
		ExceptionHandler.log.info("Caught exception", ex);
		return createResponse(HttpStatus.BAD_REQUEST, ex, "Invalid argument");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalAccessException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final IllegalAccessException ex) {
		return createResponse(HttpStatus.UNAUTHORIZED, ex, "Unauthorized");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final NoSuchElementException ex) {
		return createResponse(HttpStatus.NOT_FOUND, ex, "Not found");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(WattpadApiException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final WattpadApiException ex) {
		return createResponse(HttpStatus.NOT_FOUND, ex, "Wattpad error");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(UndeclaredThrowableException.class)
	public ResponseEntity<String> handle(final HttpServletRequest request, final UndeclaredThrowableException ex) {
		return switch (ex.getCause()) {
		case ClientAbortException e -> handle(request, e);
		case NoSuchElementException e -> handle(request, e);
		case NoResourceFoundException e -> handle(request, e);
		case IllegalAccessException e -> handle(request, e);
		case IllegalArgumentException e -> handle(request, e);
		case AsyncRequestNotUsableException e -> handle(request, e);
		default -> handle(request, ex.getCause());
		};
	}
}
