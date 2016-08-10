package com.taher.springasg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.taher.springasg.model.LoginBean;
import com.taher.springasg.model.Product;
import com.taher.springasg.model.ProductBean;

@Controller
public class CartController {
	Map<Integer, String> map = new HashMap<Integer, String>();
	int a=0;
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model, @ModelAttribute("productBean") ProductBean productBean,
			@ModelAttribute("LoginBean") LoginBean user, HttpSession session) {

		model.addAttribute("stockmap", productBean.getProductStock());
		 model.addAttribute("pricemap", productBean.getProductPrice());
		session.setAttribute("pricemap", productBean.getProductPrice());
		session.setAttribute("stockmap", productBean.getProductStock());
		session.setAttribute("stockValue", productBean.getProductStockValue());
		session.setAttribute("priceValue", productBean.getProductPriceValue());
		
		 session.setAttribute("map", map);
		return "/products";
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("Product") Product product,
			/*@ModelAttribute("productBean") ProductBean productbean,*/ HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("adka");
		ProductBean productbean ;
		if (request.getParameter("add") != null) {
			System.out.println("add got");
			map=(Map<Integer, String>) session.getAttribute("map");
						 a=map.size();
			
			System.out.println(request.getParameterValues("productStock"));
			String[] shopingItems = request.getParameterValues("productStock");
			for (int i = 0; i < shopingItems.length; i++) {
				
				map.put(a+1, shopingItems[i]);
//				Integer stock=productbean.getProductStock().get(map.get(shopingItems[i]));
//				
//				productbean.setProductStock("shopingItems[i]",stock--);;
			}

//			System.out.println("product");
//			for (String temp : product.getProductStock()) {
//				System.out.println(temp);
//			}
			request.setAttribute("map", map);
			session.setAttribute("map", map);
		} else if (request.getParameter("del") != null) {

			int key = Integer.parseInt(request.getParameter("key"));
			System.out.println("delete called");
			map.remove(key);
			request.setAttribute("map", map);
			session.setAttribute("map", map);
			return "display";
		}
		return "display";
	}
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(Model model, @ModelAttribute("productBean") ProductBean productBean,
			@ModelAttribute("LoginBean") LoginBean user, HttpSession session)
	{
		
//		Integer stock=productBean.getProductStock().get(map.get());
//		productBean.setProductStock("shopingItems[i]",stock--);;
		map=(Map<Integer, String>) session.getAttribute("map");
		session.setAttribute("sum", productBean.getProductPrice().values().toString());
		return "checkout";
	}
	/*
	 * @RequestMapping(value = "/display", method = RequestMethod.GET) public
	 * String show(Model model, @ModelAttribute("ProductBean") ProductBean
	 * productBean) {
	 * 
	 * System.out.println("show called"); return "display"; }
	 */

	// @RequestMapping(value = "/test.htm")
	// public String test() throws IOException {
	//
	//
	// if(true) {
	// throw new IOException("this is io exception");
	// }
	//
	//
	// return "products";
	// }

}
