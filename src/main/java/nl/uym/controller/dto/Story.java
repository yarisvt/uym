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
	@Schema(title = "Wattpad ID of the story", requiredMode = Schema.RequiredMode.REQUIRED)
	private final String id;

	@NotNull
	@Schema(title = "Title of the story", requiredMode = Schema.RequiredMode.REQUIRED)
	private final String title;

	@NotNull
	@Schema(title = "URL to the story", requiredMode = Schema.RequiredMode.REQUIRED)
	private final String url;

	@Schema(title = "Number of votes", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int voteCount;

	@Schema(title = "Number of comments", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int commentCount;

	@Schema(title = "Number of times the story is read", requiredMode = Schema.RequiredMode.REQUIRED)
	private final long readCount;

	@Schema(title = "Number of parts the story has", requiredMode = Schema.RequiredMode.REQUIRED)
	private final int partsCount;

	@NotNull
	@Schema(title = "Description of the story", requiredMode = Schema.RequiredMode.REQUIRED)
	private final String description;

	@NotNull
	@Schema(title = "URL of the cover image", requiredMode = Schema.RequiredMode.REQUIRED)
	private final URL cover;
}
