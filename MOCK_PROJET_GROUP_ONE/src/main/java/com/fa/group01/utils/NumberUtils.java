/**
 * 
 */
package com.fa.group01.utils;

import com.fa.group01.entity.ProductForm;
import com.fa.group01.logging.UtilsLogging;

/**
 * @author nguyenthanhlinh
 *
 */
public class NumberUtils {

	public static boolean isProductPriceValid(ProductForm product) {
		try {
			double price = Double.parseDouble(product.getPrice());
			return true;
		} catch (NumberFormatException e) {
			UtilsLogging.LOGGER.error("NumberFormatException", e);
			return false;
		}
	}
	
	public static boolean isProductQuantityValid(ProductForm product) {
		try {
			int quantity = Integer.parseInt(product.getQuantity());
			return true;
		} catch (NumberFormatException e) {
			UtilsLogging.LOGGER.error("NumberFormatException", e);
			return false;
		}
	}
}
