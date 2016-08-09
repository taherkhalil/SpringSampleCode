/**
 * 
 */
package com.taher.springasg.model;

import java.util.ArrayList;

/**
 * @author taherk
 *
 */
public class Product {
	public ArrayList<String> getProductStock() {
		return productStock;
	}

	public void setProductStock(ArrayList<String> productStock) {
		this.productStock = productStock;
	}

	ArrayList<String> productStock;

}
