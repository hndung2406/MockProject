package com.fa.group01.utils;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StorageUtilsTest {
	private StorageUtils storageUtil;
	
	@Before
	public void setUp() throws Exception {
		storageUtil = new StorageUtils();
	}

	@Test
	public void CanGetFileExtension() {
		String fileExtension = StorageUtils.getFileExtension("example.com");
		assertNotEquals(fileExtension, "[.]com");
	}
	
}
