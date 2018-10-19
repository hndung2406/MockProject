package com.fa.group01.action;

import java.util.List;


import com.fa.group01.constants.PageConstant;
import com.fa.group01.dao.productdao.impl.ProductDAOImpl;
import com.fa.group01.entity.Product;
import com.fa.group01.service.pageservice.PageService;
import com.fa.group01.service.pageservice.impl.PageServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PageAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 3693334958579046022L;

	private PageService pageService;
	private List<Product> products;
	private List<Product> listTrendingProducts;
	private int page;
	private int totalProductRecord;
	private int maxNavigationTab;

	

	@Override
	public void prepare() throws Exception {
		pageService = new PageServiceImpl(new ProductDAOImpl());
		maxNavigationTab = pageService.getMaxNavigationTabForProductPage(PageConstant.LIMIT_PRODUCTS_PER_PAGE);
		totalProductRecord = pageService.getTotalProductRecord();
		this.listTrendingProducts = pageService.fetchProductsByCreatedDate(PageConstant.FROM_CREATED_DATE_TILL_NOW);
		page = 1;// default home page has page number is 1
	}

	public String fetchProductsOnCurrentPage() {
		int rowIndexOfResultSet = (page - 1) * PageConstant.LIMIT_PRODUCTS_PER_PAGE;// default rowIndexOfResultSet = 0
		products = pageService.getLimitProductsPerPage(rowIndexOfResultSet, PageConstant.LIMIT_PRODUCTS_PER_PAGE);
		return SUCCESS;
	}
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxNavigationTab() {
		return maxNavigationTab;
	}

	public int getTotalProductRecord() {
		return totalProductRecord;
	}

	public List<Product> getListTrendingProducts() {
		return listTrendingProducts;
	}	

}
