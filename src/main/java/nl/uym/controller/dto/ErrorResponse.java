package nl.uym.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author Yaris van Thiel
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Jacksonized
public class ErrorResponse {

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private int status;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String message;
}
