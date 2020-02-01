package com.weather.region.util;

public class WeatherUtil {

	public static boolean isNumeric(final String str) {

		if (str == null || str.length() == 0) {
			return false;
		}

		return str.chars().allMatch(Character::isDigit);

	}

}
