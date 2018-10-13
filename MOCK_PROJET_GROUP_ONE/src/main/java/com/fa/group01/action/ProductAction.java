/**
 * 
 */
package com.fa.group01.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.entity.ProductForm;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.logging.UtilsLogging;
import com.fa.group01.service.manufactureservice.ManufactureService;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.fa.group01.utils.StorageUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManufactureDAO manufactureDao = new ManufactureDAOImpl();
	private ManufactureService manufactureService;
	private ProductDAO productDao = new ProductDAOImpl();
	private ProductService productService;
	private ProductForm productForm;
	private Date dateOfManufacture;
	private List<Manufacture> manufactures;
	private Manufacture manufacture;
	private String message;
	
	public ProductAction() {
		manufactureService = new ManufactureServiceImpl(manufactureDao);
		productService = new ProductServiceImpl(productDao);
	}
	
	public String showAddProductPage() {
		try {
			manufactures = manufactureService.findAll();
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException", e);
		}
		return PageConstant.SUCCESS;
	}

	public String addProduct() {
		String randomName = "";
		int isAddSuccess = 0;
		
		if (productForm.getImage() != null) {
			try {
				String randomCode = UUID.randomUUID().toString();
				String originFileName = productForm.getImage().getName();
				randomName = randomCode + StorageUtils.getFileExtension(originFileName);
				File file = new File(StorageUtils.WIN_LOCATION, randomName);
				
				FileUtils.copyFile(productForm.getImage(), file);
				
			} catch (IOException e) {
				UtilsLogging.LOGGER.error("IOException", e);
			}
		}
		Product product = new Product();
		product.setId(productForm.getId());
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setImageUrl(productForm.getImageUrl());
		product.setCondition(productForm.getCondition());
		product.setSpec(productForm.getSpec());
		product.setProperties(productForm.getProperties());
		product.setManufacture(manufacture);
		product.setImageUrl(randomName);
		if (dateOfManufacture != null) {
			product.setDateOfManufacture(new java.sql.Date(dateOfManufacture.getTime()));
		}
		System.out.println(productForm.getPrice());
		if (productForm.getPrice() != null) {
			product.setPrice(Double.parseDouble(productForm.getPrice()));
		}
		if (productForm.getQuantity() != null) {
			product.setQuantity(Integer.parseInt(productForm.getQuantity()));
		}
		
		try {
			manufactures = manufactureService.findAll();
			isAddSuccess = productService.save(product);
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException", e);
		}
		
		if (isAddSuccess > 0) {
			message = "Add Success!";
			return PageConstant.SUCCESS;
		}
		message = "Add Fail!";
		return PageConstant.ERROR;
	}

	public ProductForm getProductForm() {
		return productForm;
	}

	public void setProductForm(ProductForm productForm) {
		this.productForm = productForm;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public List<Manufacture> getManufactures() {
		return manufactures;
	}

	public void setManufactures(List<Manufacture> manufactures) {
		this.manufactures = manufactures;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}