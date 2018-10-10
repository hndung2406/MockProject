/**
 * 
 */
package com.fa.group01.entity;

/**
 * @author nguyenthanhlinh
 *
 */
public class Manufacture {

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
