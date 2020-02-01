package com.weather.region.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerResponseHelper {

	public static <T> ResponseEntity<T> getResponse(T entity, HttpStatus status) {
		return ControllerResponseHelper.buildResponseEntity(entity, (HttpHeaders) null, status);
	}

	private static <T> ResponseEntity<T> buildResponseEntity(T entity, HttpHeaders httpHeaders, HttpStatus status) {
		if (httpHeaders == null) {
			httpHeaders = new HttpHeaders();
		}
		return new ResponseEntity<T>(entity, httpHeaders, status);
	}

}
