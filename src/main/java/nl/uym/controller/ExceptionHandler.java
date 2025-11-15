package nl.uym.controller;

import nl.uym.controller.dto.ErrorResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wattpad4j.api.WattpadApiException;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yaris van Thiel
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

	private ResponseEntity<ErrorResponse> createResponse(final HttpStatus status, final Throwable dto, final String d) {
		return createResponse(status, ErrorResponse.builder()
		        .status(status.value())
		        .message(StringUtils.trimToNull(StringUtils.defaultIfBlank(dto.getMessage(), d)))
		        .build());
	}

	private <T> ResponseEntity<T> createResponse(final HttpStatus status, final T dto) {
		return new ResponseEntity<>(dto, status);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
	@ApiResponse(responseCode = "400", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
	public ResponseEntity<ErrorResponse> handle(final IllegalArgumentException ex) {
		ExceptionHandler.log.info("Caught exception", ex);
		return createResponse(HttpStatus.BAD_REQUEST, ex, "Invalid argument");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(WattpadApiException.class)
	@ApiResponse(responseCode = "404", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
	public ResponseEntity<ErrorResponse> handle(final WattpadApiException ex) {
		return createResponse(HttpStatus.NOT_FOUND, ex, "Wattpad error");
	}
}
