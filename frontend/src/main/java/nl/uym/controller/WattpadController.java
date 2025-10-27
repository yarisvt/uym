package nl.uym.controller;

import java.util.List;

import nl.uym.controller.dto.Story;
import nl.uym.wattpad.WattpadAPI;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	private final WattpadAPI wattpadAPI;
	private final ConversionService convert;

	/**
	 * Returns a list of Wattpad stories transformed to the API's Story DTO.
	 *
	 * @return list of stories in JSON-friendly format
	 */
	@GetMapping("/stories")
	public List<Story> getStories() {
		return wattpadAPI.getStories().getStories().stream()
		        .map(s -> convert.convert(s, Story.class))
		        .toList();
	}

}
