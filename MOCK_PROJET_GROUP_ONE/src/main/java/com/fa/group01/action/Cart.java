/**
 * 
 */
package com.fa.group01.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Product;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.service.productservice.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author DungHN2
 *
 */
public class Cart extends ActionSupport implements Preparable, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6840147582101483525L;
	private Map<Product, Integer> cart;
	private String id;
	private Map<String, Object> cartSession;
	private ProductService productService;
	private ProductDAO productDao;
	private Product product;
	private int quantity;

	@Override
	public void prepare() throws Exception {
		cartSession = ActionContext.getContext().getSession();
		productDao = new ProductDAOImpl();
		productService = new ProductServiceImpl(productDao);
	}

	public String changeQuantity() {
		product = productService.findById(id);
		cart = getCart();
		if (!cart.isEmpty()) {
			cart.put(product, quantity);
			cartSession.put("cart", cart);
		}
		return PageConstant.SUCCESS;
	}

	public String deleteProductFromCart() {
		System.out.println(id);
		product = productService.findById(id);
		cart = getCart();
		if (!cart.isEmpty()) {
			cart.remove(product);
			cartSession.put("cart", cart);
		}
		return PageConstant.SUCCESS;
	}

	public String showCartSession() {
		cart = getCart();
		return PageConstant.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String addToCart() {
		if (cartSession.isEmpty()) {
			cart = new HashMap<Product, Integer>();
			cartSession.put("cart", cart);
		}
		cart = (Map<Product, Integer>) cartSession.get("cart");
		Product product = null;
		product = productService.findById(id);
		if (cart.containsKey(product)) {
			int quantity = cart.get(product);
			quantity += 1;
			cart.put(product, quantity);
		} else {
			cart.put(product, 1);
		}
		cartSession.put("cart", cart);
		return PageConstant.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public Map<Product, Integer> getCart() {
		if (!cartSession.isEmpty()) {
			cart = (Map<Product, Integer>) cartSession.get("cart");
			return cart;
		}
		return null;
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

	public void setCart(Map<Product, Integer> cart) {
		this.cart = cart;
	}

}
