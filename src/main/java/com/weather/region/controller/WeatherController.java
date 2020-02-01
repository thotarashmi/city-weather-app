package com.weather.region.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.weather.region.converters.ConverterFacade;
import com.weather.region.dto.ResponseDto;
import com.weather.region.dto.WeatherDTO;
import com.weather.region.exceptions.IllegalRequestException;
import com.weather.region.helper.ControllerResponseHelper;
import com.weather.region.model.Weather;
import com.weather.region.service.WeatherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

	private final WeatherService weatherService;
	private final ConverterFacade converterFacade;

	@RequestMapping(path = "/{zipOrCity}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getWeatherInformation_Fallback")
	ResponseEntity<ResponseDto<WeatherDTO>> getWeatherInformation(@PathVariable(name = "zipOrCity") String zipOrcity) {
		Weather weather = weatherService.getWeatherInfo(zipOrcity);
		WeatherDTO weatherDTO = converterFacade.convertToDTO(weather, WeatherDTO.class);
		ResponseDto<WeatherDTO> responseDto = new ResponseDto<>();
		responseDto.setData(weatherDTO);
		return ControllerResponseHelper.getResponse(responseDto, HttpStatus.OK);
	}

	private ResponseEntity<ResponseDto<WeatherDTO>> getWeatherInformation_Fallback(String schoolname) {
		System.out.println("weather API is down!!! fallback route enabled...");
		throw new RuntimeException("Invalid Zip or City");

	}

}
