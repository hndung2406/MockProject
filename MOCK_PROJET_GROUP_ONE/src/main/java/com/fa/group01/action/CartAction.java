/**
 * 
 */
package com.fa.group01.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Product;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class CartAction extends ActionSupport implements Preparable, SessionAware {

	private static final long serialVersionUID = -6840147582101483525L;
	private Map<Product, Integer> cart;
	private String id;
	private Map<String, Object> cartSession;
	private ProductService productService;
	private ProductDAO productDao;
	private Product product;
	private int quantity;
	private int totalQuantity;

	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		this.cart = (Map<Product, Integer>) cartSession.get("cart");
		productDao = new ProductDAOImpl();
		productService = new ProductServiceImpl(productDao);
	}

	public String changeQuantity() {
		product = productService.findById(id);		
		if (!cart.isEmpty()) {
			cart.put(product, quantity);			
		}
		return PageConstant.SUCCESS;
	}

	public String deleteProductFromCart() {
		product = productService.findById(id);		
		if (!cart.isEmpty()) {
			cart.remove(product);			
			
		}
		return PageConstant.SUCCESS;
	}

	public String showCartSession() {
		totalQuantity = 0;
		if(cart != null) {
			for(int val: cart.values()) {
				totalQuantity += val;
			}
		}
		return PageConstant.SUCCESS;
	}

	
	public String addToCart() {
		Product product = productService.findById(id);	
		if (!cart.isEmpty() && cart.containsKey(product)) {
			int quantity = cart.get(product);
			quantity += 1;
			cart.put(product, quantity);
		} else {
			cart.put(product, 1);
		}
		return PageConstant.SUCCESS;
	}	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.cartSession = session;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
