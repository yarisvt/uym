package nl.uym.controller.dto;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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
public class Story {

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final String id;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final String title;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final int voteCount;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final int commentCount;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final String description;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final URL cover;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final String url;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final int numParts;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private final long readCount;

}
