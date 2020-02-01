package com.weather.region.converters.impl;

import org.springframework.stereotype.Component;

import com.weather.region.annotations.DTOConverter;
import com.weather.region.converters.SimpleEntityDtoConverter;
import com.weather.region.dto.WeatherDTO;
import com.weather.region.model.Weather;

@Component
@DTOConverter(source = Weather.class, destination = WeatherDTO.class)
public class WeatherConverter extends SimpleEntityDtoConverter<Weather, WeatherDTO> {

	public WeatherConverter() {
		super(Weather.class, WeatherDTO.class);
	}

}
