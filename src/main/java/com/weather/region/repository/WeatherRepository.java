package com.weather.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weather.region.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer>, JpaSpecificationExecutor<Weather> {
		
	 @Query("SELECT w FROM Weather w WHERE w.city.zipCode = :zipCode")
	 Weather findWeatherByCityZipCode(@Param("zipCode") Integer zipCode);
	 
	 @Query("SELECT w FROM Weather w WHERE w.city.cityName = :cityName")
	 Weather findWeatherByCityName(@Param("cityName") String cityName);
}
