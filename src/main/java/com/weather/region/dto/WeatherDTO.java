package com.weather.region.dto;

import java.util.Date;

import lombok.Data;

@Data
public class WeatherDTO {
	String temperature;
	String wind;
	Integer humidity;
	String airQuality;
	Integer airQualityIndex;
	Date sunrise;

}
