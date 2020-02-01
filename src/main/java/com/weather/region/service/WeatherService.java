package com.weather.region.service;

import org.springframework.stereotype.Service;

import com.weather.region.exceptions.IllegalRequestException;
import com.weather.region.model.Weather;
import com.weather.region.repository.WeatherRepository;
import com.weather.region.util.WeatherUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

	private final WeatherRepository weatherRepository;

	public Weather getWeatherByZipCode(Integer zipCode) {
		return weatherRepository.findWeatherByCityZipCode(zipCode);

	}

	public Weather getWeatherByCity(String cityName) {
		return weatherRepository.findWeatherByCityName(cityName);

	}

	public Weather getWeatherInfo(String zipOrcity) {
	  try {
		  if(WeatherUtil.isNumeric(zipOrcity)) {
				return getWeatherByZipCode(Integer.parseInt(zipOrcity));
			}else {
				return getWeatherByCity(zipOrcity);
			}
	  }catch(Exception e) {
		  throw new IllegalRequestException("Invalid Zip or City");
	  }
		
	}
	
}
