package com.training.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String FORMAT_1 = "yyyy-MM-dd";

	public static Date format_1(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_1);
		try {
			return sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
