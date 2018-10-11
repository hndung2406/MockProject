/**
 * 
 */
package com.fa.group01.entity;

import java.io.File;
import java.sql.Date;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductForm {
	
	private String id;
	private String name;
	private String price;
	private String description;
	private File image;
	private String imageUrl;
	private String quantity;
	private String condition;
	private Date dateOfManufacture;
	private String spec;
	private String properties;
	private Manufacture manufacture;
	
	public ProductForm() {

	}

	public ProductForm(String id, String name, String price, String description, File image, String imageUrl,
			String quantity, String condition, Date dateOfManufacture, String spec, String properties,
			Manufacture manufacture) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.condition = condition;
		this.dateOfManufacture = dateOfManufacture;
		this.spec = spec;
		this.properties = properties;
		this.manufacture = manufacture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

}
