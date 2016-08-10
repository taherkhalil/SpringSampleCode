package com.taher.springasg.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductBean {
	
	public Map<String, Integer> getProductStock() {
		return productStock;
	}
	public Collection<Integer> getProductStockValue() {
				return  productStock.values();
	}
	public void setProductStock(Map<String, Integer> productStock) {
		this.productStock = productStock;
	}
	public Map<String, Integer> getProductPrice() {
		return productPrice;
	}
	public Collection<Integer> getProductPriceValue() {
		return  productPrice.values();
		}
	public void setProductPrice(Map<String, Integer> productPrice) {
		this.productPrice = productPrice;
	}
	Map<String, Integer> productStock = new HashMap<String,Integer>();
	Map<String, Integer> productPrice = new HashMap<String,Integer>();
	
	public ProductBean(){
		productStock.put("belt", 10);
		productStock.put("watch", 10);
		productStock.put("socks", 10);
		productPrice.put("belt",150);
		productPrice.put("watch",250);
		productPrice.put("socks",50);
		
	}


}
