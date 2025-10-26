package nl.uym.convert;

import nl.uym.controller.dto.Story;
import nl.uym.wattpad.dto.WattpadStory;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.NonNull;

/**
 * @author Yaris van Thiel
 */
@Component
public class WattpadStoryToStoryConverter implements Converter<WattpadStory, Story> {

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
		        .numParts(source.getNumParts())
		        .readCount(source.getReadCount())
		        .build();
	}
}
