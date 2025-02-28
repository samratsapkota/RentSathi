package com.rent.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonController {

	/** get CurrentDateTime */
	public static Timestamp getCurrentDateTime() {
		java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
		java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
		java.sql.Timestamp ts = new java.sql.Timestamp(sqlDate1.getTime());

		return ts;
	}
	
	/** get CurrentDate */
	public static java.sql.Date getCurrentDate() {
		java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
		java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());

		return sqlDate1;
	}
	
	/** convert string to date*/
	public static Date convertStringToDate(String date) {
		if (date == null || date.equals("") || date.equals("null")) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date);
			return new Date(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
