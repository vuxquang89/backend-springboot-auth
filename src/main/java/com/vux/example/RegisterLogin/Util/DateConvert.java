package com.vux.example.RegisterLogin.Util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConvert {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
}
