package com.weather.region.exceptions;

public class IllegalRequestException extends RuntimeException {

	public IllegalRequestException(String message, Throwable e) {
		super(message, e);
	}

	public IllegalRequestException(String message) {
		super(message);
	}
}
