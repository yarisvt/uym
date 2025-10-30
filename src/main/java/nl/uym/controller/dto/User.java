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
public class User {

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String username;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private URL avatar;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private URL backgroundUrl;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String description;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private String location;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private URL website;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Long votesReceived;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numStoriesPublished;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numFollowing;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numFollowers;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numMessages;

	@NotNull
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer numLists;

}
