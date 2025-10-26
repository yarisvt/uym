package nl.uym.wattpad.dto;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class WattpadStory {

	private final String id;
	private final String title;
	private final int voteCount;
	private final int commentCount;
	private final String description;
	private final URL cover;
	private final URL url;
	private final int numParts;
	private final long readCount;
}
