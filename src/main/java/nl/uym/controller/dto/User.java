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
	@Schema(title = "Name of the user", requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;

	@NotNull
	@Schema(title = "Username of the user", requiredMode = Schema.RequiredMode.REQUIRED)
	private String username;

	@NotNull
	@Schema(title = "Description of the user", requiredMode = Schema.RequiredMode.REQUIRED)
	private String description;

	@NotNull
	@Schema(title = "Location of the user", requiredMode = Schema.RequiredMode.REQUIRED)
	private String location;

	@NotNull
	@Schema(title = "URL to the avatar", requiredMode = Schema.RequiredMode.REQUIRED)
	private URL avatar;

	@NotNull
	@Schema(title = "URL to the background", requiredMode = Schema.RequiredMode.REQUIRED)
	private URL backgroundUrl;

	@NotNull
	@Schema(title = "URL to the website", requiredMode = Schema.RequiredMode.REQUIRED)
	private URL website;

	@NotNull
	@Schema(title = "Number of votes received", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long votesReceived;

	@NotNull
	@Schema(title = "Number of stories published", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer publishedStoriesCount;

	@NotNull
	@Schema(title = "Number of following", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer followingCount;

	@NotNull
	@Schema(title = "Number of followers", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer followersCount;

	@NotNull
	@Schema(title = "Number of messages", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer messagesCount;

	@NotNull
	@Schema(title = "Number of lists", requiredMode = Schema.RequiredMode.REQUIRED)
	private Integer listsCount;

}
