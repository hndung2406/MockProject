/**
 * 
 */
package com.fa.group01.action;

import java.sql.SQLException;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.manufacture.ManufactureDAO;
import com.fa.group01.dao.manufacture.impl.ManufactureDAOImpl;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.logging.DbLogging;
import com.fa.group01.service.manufactureservice.ManufactureService;
import com.fa.group01.service.manufactureservice.impl.ManufactureServiceImpl;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DungHN2
 *
 */
public class ProductDetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6359901664588852894L;
	private String id;
	private Product product;
	private Manufacture manufacture;
	private ProductDAO productDao = new ProductDAOImpl();
	private ProductService productService = new ProductServiceImpl(productDao);
	private ManufactureDAO manufactureDao = new ManufactureDAOImpl();
	private ManufactureService manufactureService = new ManufactureServiceImpl(manufactureDao);
	private String[] productProperties;
	private String[] productSpec;
	
	
	public String productDetail() {
		try {
			product = productService.findById(id);
			int manufactureId = product.getManufacture().getManufactureId();
			manufacture = manufactureService.findById(manufactureId);
			productProperties = productService.splitStringProduct(product.getProperties());
			productSpec = productService.splitStringProduct(product.getSpec());
		} catch (SQLException e) {
			DbLogging.LOG.error("ERROR", e);
		}
		return PageConstant.SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public String[] getProductProperties() {
		return productProperties;
	}

	public void setProductProperties(String[] productProperties) {
		this.productProperties = productProperties;
	}

	public String[] getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String[] productSpec) {
		this.productSpec = productSpec;
	}
	
}
