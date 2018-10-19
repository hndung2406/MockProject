package com.fa.group01.utils;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateUtilsTest {

	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Rule 
	public ExpectedException thrown  = ExpectedException.none();

	@Test	
	public void CanConvertCorrectStringFormatDateToSqlDate() {
		
		Date sqlDate = DateUtils.getDateByStringFormat("2018-01-10");
		assertNotEquals(sqlDate,null);
	}

	@Test()
	public void CanConvertNotCorrectStringFormatDateToSqlDate() {
		thrown.expect(DateTimeParseException.class);
		DateUtils.getDateByStringFormat("2018-0219");
		
	}
}
