package com.vux.example.RegisterLogin.Util;

public class LocalDateConvert {

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
			return dates[2] +"-"+dates[0]+"-"+dates[1];
		}
		return str;
	}
}
