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

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

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
import com.opensymphony.xwork2.inject.Inject;

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
	private Product dbProduct;
	
	public ProductAction() {
		manufactureService = new ManufactureServiceImpl(manufactureDao);
		productService = new ProductServiceImpl(productDao);
	}
	
	public String showUpdateProduct() {
		try {
			dbProduct = productService.findById(productId);
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException", e);
		}
		return PageConstant.SUCCESS;
	}

	public String showProducts() {
		
		try {
			products = productService.findAll();
		} catch (SQLException e) {
			DbLogging.LOGGER.error("SQLException", e);
		}
		return PageConstant.SUCCESS;

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

	public Product getDbProduct() {
		return dbProduct;
	}

	public void setDbProduct(Product dbProduct) {
		this.dbProduct = dbProduct;
	}

}