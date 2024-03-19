package com.vux.example.RegisterLogin.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateConvert {
	final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String stringToDateString(String str) {
		String[] dates = str.split("/");
		if(dates.length > 1) {
			//String date = String.join("-",dates);
			if(dates[0].length() < 2) {
				dates[0] = "0"+dates[0];
			}
			if(dates[1].length() < 2) {
				dates[1] = "0"+dates[1];
			}
			//return dates[2] +"-"+dates[0]+"-"+dates[1];
			return dates[2] +"-"+dates[1]+"-"+dates[0];
		}
		return str;
	}
	
	public static String localDateTimeToString(LocalDateTime localDateTime) {		

		return localDateTime.format(CUSTOM_FORMATTER);
	}
}
