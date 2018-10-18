/**
 * 
 */
package com.fa.group01.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author nguyenthanhlinh
 *
 */
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private double price;
	private String description;
	private String imageUrl;
	private int quantity;
	private String condition;
	private Date dateOfManufacture;
	private String spec;
	private String properties;
	private Manufacture manufacture;
	

	public Product() {

	}

	public Product(String id, String name, double price, String description, String imageUrl, int quantity,
			String condition, Date dateOfManufacture, String spec, String properties, Manufacture manufacture) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", quantity=" + quantity + ", condition=" + condition
				+ ", dateOfManufacture=" + dateOfManufacture + ", spec=" + spec + ", properties=" + properties
				+ ", manufacture=" + manufacture + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((dateOfManufacture == null) ? 0 : dateOfManufacture.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((manufacture == null) ? 0 : manufacture.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((spec == null) ? 0 : spec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (dateOfManufacture == null) {
			if (other.dateOfManufacture != null)
				return false;
		} else if (!dateOfManufacture.equals(other.dateOfManufacture))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (manufacture == null) {
			if (other.manufacture != null)
				return false;
		} else if (!manufacture.equals(other.manufacture))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (quantity != other.quantity)
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		return true;
	}
	
}
