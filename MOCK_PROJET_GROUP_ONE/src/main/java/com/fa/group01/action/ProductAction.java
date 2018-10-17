/**
 * 
 */
package com.fa.group01.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
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
	private String id;

	public ProductAction() {
		manufactureService = new ManufactureServiceImpl(manufactureDao);
		productService = new ProductServiceImpl(productDao);
	}

	public String showDeleteProductPage() {
		product = productService.findById(id);
		manufacture = manufactureService.findById(product.getManufacture().getManufactureId());
		return PageConstant.SUCCESS;
	}

	public String deleteProduct() {
		int isDeleted = 0;
		product = productService.findById(product.getId());
		StorageUtils.removeFile(product.getImageUrl());
		isDeleted = productService.deleteProduct(product.getId());
		if (isDeleted > 0) {
			return PageConstant.SUCCESS;
		} else {
			return PageConstant.ERROR;
		}
	}

	public String showUpdateProductPage() {
		manufactures = manufactureService.findAll();
		product = productService.findById(id);
		manufacture = manufactureService.findById(product.getManufacture().getManufactureId());
		product.setManufacture(manufacture);
		return PageConstant.SUCCESS;
	}

	public String updateProduct() {
		String randomName = "";
		int isAddSuccess = 0;
		randomName = productService.getRandomName(randomName, image, imageFileName);
		manufacture = manufactureService.findById(manufacture.getManufactureId());
		manufactures = manufactureService.findAll();
		productService.setProduct(product, randomName, manufacture, dateOfManufacture);
		isAddSuccess = productService.updateProduct(product);
		if (isAddSuccess > 0) {
			message = "Update Success!";
			return PageConstant.SUCCESS;
		} else {
			message = "Update Fail!";
			return PageConstant.ERROR;
		}
	}

	public String showAddProductPage() {
		manufactures = manufactureService.findAll();
		return PageConstant.SUCCESS;
	}

	public String addProduct() {
		String randomName = "";
		randomName = productService.getRandomName(randomName, image, imageFileName);
		productService.setProduct(product, randomName, manufacture, dateOfManufacture);
		manufactures = manufactureService.findAll();
		int isAddSuccess = productService.addProduct(product);
		if (isAddSuccess > 0) {
			message = "Add Success!";
			return PageConstant.SUCCESS;
		} else {
			message = "Add Fail!";
			return PageConstant.ERROR;
		}
	}

	public String showProducts() {
		products = productService.findAllProduct();
		return PageConstant.SUCCESS;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}