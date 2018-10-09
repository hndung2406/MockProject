/**
 * 
 */
package com.fa.group01.entity;

/**
 * @author nguyenthanhlinh
 *
 */
public class Manufacture {

	private int id;
	private String name;

	public Manufacture() {

	}

	/**
	 * @param id
	 * @param name
	 */
	public Manufacture(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
