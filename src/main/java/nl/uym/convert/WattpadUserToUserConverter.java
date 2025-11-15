package nl.uym.convert;

import nl.uym.controller.dto.User;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wattpad4j.models.WattpadUser;

import lombok.NonNull;

/**
 * @author Yaris van Thiel
 */
@Component
public class WattpadUserToUserConverter implements Converter<WattpadUser, User> {

	/**
	 * Converts a WattpadStory domain object to the public Story DTO used by the API.
	 *
	 * @param source the WattpadStory to convert (must not be null)
	 * @return a new Story instance populated from the source
	 */
	@Override
	public User convert(@NonNull WattpadUser source) {
		return User.builder()
		        .username(source.getUsername())
		        .avatar(source.getAvatar())
		        .backgroundUrl(source.getBackgroundUrl())
		        .name(source.getName())
		        .description(source.getDescription())
		        .location(source.getLocation())
		        .website(source.getWebsite())
		        .votesReceived(source.getVotesReceived())
		        .publishedStoriesCount(source.getNumStoriesPublished())
		        .followingCount(source.getNumFollowing())
		        .followersCount(source.getNumFollowers())
		        .messagesCount(source.getNumMessages())
		        .listsCount(source.getNumLists())
		        .build();
	}
}
