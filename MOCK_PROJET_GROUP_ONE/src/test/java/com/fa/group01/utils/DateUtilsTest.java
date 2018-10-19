package com.fa.group01.utils;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class DateUtilsTest {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test	
	public void CanConvertCorrectStringFormatDateToSqlDate() {
		
		Date sqlDate = DateUtils.getDateByStringFormat("2018-01-10");
		assertEquals(sqlDate,null);
	}

	@Test	
	public void CanConvertNotCorrectStringFormatDateToSqlDate() {		
		Date sqlDate = DateUtils.getDateByStringFormat("201802-19");
		assertEquals(sqlDate,null);
	}
}
