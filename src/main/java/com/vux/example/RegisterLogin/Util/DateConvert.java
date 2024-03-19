package com.vux.example.RegisterLogin.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvert {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public static boolean isAfter(String otherDate) {
		LocalDate otherLocalDate = LocalDate.parse(otherDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate localDate = LocalDate.now();
		
		return localDate.isAfter(otherLocalDate);
	}
	
	public static boolean isBefore(String otherDate) {
		LocalDate otherLocalDate = LocalDate.parse(otherDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate localDate = LocalDate.now();
		
		return localDate.isBefore(otherLocalDate);
	}
}
