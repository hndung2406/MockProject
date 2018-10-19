/**
 * 
 */
package com.fa.group01.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * @author DungHN2
 *
 */
public class DateUtils {

	public static Date getDate() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		return out;
	}

	public static java.sql.Date getDateByStringFormat(String stringDate) throws DateTimeParseException{
		 LocalDate localDate = LocalDate.parse(stringDate);		 
		 return java.sql.Date.valueOf(localDate);
	}
}
