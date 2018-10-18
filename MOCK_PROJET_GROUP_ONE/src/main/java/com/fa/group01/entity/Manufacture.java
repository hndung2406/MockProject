/**
 * 
 */
package com.fa.group01.entity;

import java.io.Serializable;

/**
 * @author nguyenthanhlinh
 *
 */
public class Manufacture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5496976169080978889L;
	private int manufactureId;
	private String manufactureName;

	public Manufacture(int manufactureId, String manufactureName) {
		this.manufactureId = manufactureId;
		this.manufactureName = manufactureName;
	}
	
	public Manufacture() {

	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}
	
}
