package nl.uym.convert;

import nl.uym.controller.dto.Story;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wattpad4j.models.WattpadStory;

import lombok.NonNull;

/**
 * @author Yaris van Thiel
 */
@Component
public class WattpadStoryToStoryConverter implements Converter<WattpadStory, Story> {

	/**
	 * Converts a WattpadStory domain object to the public Story DTO used by the API.
	 *
	 * @param source the WattpadStory to convert (must not be null)
	 * @return a new Story instance populated from the source
	 */
	@Override
	public Story convert(@NonNull WattpadStory source) {
		return Story.builder()
		        .id(source.getId())
		        .title(source.getTitle())
		        .voteCount(source.getVoteCount())
		        .commentCount(source.getCommentCount())
		        .description(source.getDescription())
		        .cover(source.getCover())
		        .url(source.getUrl())
		        .partsCount(source.getNumParts())
		        .readCount(source.getReadCount())
		        .build();
	}
}
