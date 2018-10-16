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
	private Product product;
	private File image;
	private String imageFileName;
	private Date dateOfManufacture;
	private List<Manufacture> manufactures;
	private Manufacture manufacture;
	private String message;
	private List<Product> products;
	private String productId;

	public ProductAction() {
		manufactureService = new ManufactureServiceImpl(manufactureDao);
		productService = new ProductServiceImpl(productDao);
	}

	public String showDeleteProductPage() {
		try {
			product = productService.findById(productId);
			manufacture = manufactureService.findById(product.getManufacture().getManufactureId());
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		return PageConstant.SUCCESS;
	}
	
	public String deleteProduct() {
		int isDeleted = 0;
		try {
			product = productService.findById(product.getId());
			StorageUtils.removeFile(product.getImageUrl());
			isDeleted = productService.deleteProduct(product.getId());
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		if (isDeleted > 0) {
			return PageConstant.SUCCESS;
		}
		return PageConstant.ERROR;
	}

	public String showUpdateProductPage() {
		try {

			manufactures = manufactureService.findAll();
			product = productService.findById(productId);
			manufacture = manufactureService.findById(product.getManufacture().getManufactureId());
			product.setManufacture(manufacture);
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		return PageConstant.SUCCESS;
	}

	public String updateProduct() {
		String randomName = "";
		int isAddSuccess = 0;

		if (image != null) {
			try {
				StorageUtils.removeFile(product.getImageUrl());
				String randomCode = UUID.randomUUID().toString();
				randomName = randomCode + StorageUtils.getFileExtension(imageFileName);

				File file = new File(StorageUtils.FEATURE_LOCATION, randomName);
				FileUtils.copyFile(image, file);
				product.setImageUrl(randomName);
			} catch (IOException e) {
				UtilsLogging.LOGGER.error("IOException", e);
			}
		}
		if (dateOfManufacture != null) {
			product.setDateOfManufacture(new java.sql.Date(dateOfManufacture.getTime()));
		}
		try {
			manufacture = manufactureService.findById(manufacture.getManufactureId());
			manufactures = manufactureService.findAll();
			product.setManufacture(manufacture);
			isAddSuccess = productService.updateProduct(product);
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}

		if (isAddSuccess > 0) {
			message = "Update Success!";
			return PageConstant.SUCCESS;
		}
		message = "Update Fail!";
		return PageConstant.ERROR;
	}

	public String showProducts() {

		try {
			products = productService.findAllProduct();
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		return PageConstant.SUCCESS;

	}

	public String showAddProductPage() {
		try {
			manufactures = manufactureService.findAll();
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}
		return PageConstant.SUCCESS;
	}

	public String addProduct() {
		String randomName = "";
		int isAddSuccess = 0;

		if (image != null) {
			try {
				String randomCode = UUID.randomUUID().toString();
				randomName = randomCode + StorageUtils.getFileExtension(imageFileName);

				File file = new File(StorageUtils.FEATURE_LOCATION, randomName);
				FileUtils.copyFile(image, file);
			} catch (IOException e) {
				UtilsLogging.LOGGER.error("IOException", e);
			}
		}
		product.setImageUrl(randomName);
		product.setManufacture(manufacture);
		if (dateOfManufacture != null) {
			product.setDateOfManufacture(new java.sql.Date(dateOfManufacture.getTime()));
		}
		try {
			manufactures = manufactureService.findAll();
			isAddSuccess = productService.addProduct(product);
		} catch (SQLException e) {
			DbLogging.LOG.error("SQLException", e);
		}

		if (isAddSuccess > 0) {
			message = "Add Success!";
			return PageConstant.SUCCESS;
		}
		message = "Add Fail!";
		return PageConstant.ERROR;
	}

	public String getAllProducts() {
		try {
			products = productService.fetchAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}