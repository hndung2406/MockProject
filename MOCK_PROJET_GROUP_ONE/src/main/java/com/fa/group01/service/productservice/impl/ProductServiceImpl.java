/**
 * 
 */
package com.fa.group01.service.productservice.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.fa.group01.dao.productdao.ProductDAO;
import com.fa.group01.entity.Manufacture;
import com.fa.group01.entity.Product;
import com.fa.group01.logging.UtilsLogging;
import com.fa.group01.service.productservice.ProductService;
import com.fa.group01.utils.StorageUtils;

/**
 * @author nguyenthanhlinh
 *
 */
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDao;

	public ProductServiceImpl(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}

	@Override
	public Product findById(String productId) {
		return this.productDao.findById(productId);
	}

	@Override
	public String[] splitStringProduct(String productString) {
		String[] split = productString.split("\\.+");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].trim() + ".";
		}
		return split;
	}

	@Override
	public int updateProduct(Product product) {
		return this.productDao.updateProduct(product);
	}

	@Override
	public List<Product> fetchThreeProductsOnOneSinglePage(int rowIndex, int maxNumberOfRecords) throws SQLException {
		return this.productDao.fetchLimitNumberOfProducts(rowIndex, maxNumberOfRecords);
	}

	@Override
	public int deleteProduct(String productId) {
		return this.productDao.deleteProduct(productId);
	}

	@Override
	public String getRandomName(String randomName, File image, String imageFileName) {
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
		return randomName;
	}

	@Override
	public Product setProduct(Product product, String randomName, Manufacture manufacture, Date dateOfManufacture) {
		product.setImageUrl(randomName);
		product.setManufacture(manufacture);
		if (dateOfManufacture != null) {
			product.setDateOfManufacture(new java.sql.Date(dateOfManufacture.getTime()));
		}
		return product;
	}
	
}
