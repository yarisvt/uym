package nl.uym.controller;

import java.util.List;

import nl.uym.controller.dto.Story;
import nl.uym.controller.dto.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wattpad4j.api.WattpadApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller exposing a minimal API around Wattpad content for the frontend.
 *
 * @author Yaris van Thiel
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/wattpad", produces = MediaType.APPLICATION_JSON_VALUE)
public class WattpadController {

	@Value("${nl.uym.wattpad.config.username}")
	private String userName;

	private final WattpadApi wattpadAPI;
	private final ConversionService convert;

	/**
	 * Returns a list of Wattpad Stories transformed to the API's Story DTO.
	 *
	 * @return list of stories in JSON-friendly format
	 */
	@GetMapping("/stories")
	public List<Story> getStories() throws InterruptedException {
		return wattpadAPI.getStories(userName, false).getStories().stream()
		        .map(s -> convert.convert(s, Story.class))
		        .toList();
	}

	/**
	 * Returns a Wattpad User transformed to the API's User DTO.
	 *
	 * @return User in JSON-friendly format
	 */
	@GetMapping("/user")
	public User getUser() {
		return convert.convert(wattpadAPI.getUser(userName), User.class);
	}
}
