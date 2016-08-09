package com.taher.springasg.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taher.springasg.model.LoginBean;
import com.taher.springasg.model.LoginValidator;
import com.taher.springasg.model.ProductBean;

@Controller
public class CartController {
	@Autowired
	LoginValidator logValidator;

	@InitBinder("LoginBean")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(logValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginBean", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") /* @Validated */ LoginBean loginBean,
			final RedirectAttributes redirectAttributes, BindingResult result, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("asd");
		logValidator.validate(loginBean, result);
		System.out.println("result.hasErrors() : " + result.hasErrors());
		if (!result.hasErrors()) {
			if (loginBean.getEmail().equals("taher@gmail.com") && loginBean.getPassword().equals("1234")) {
				System.out.println("session created");

				session.setAttribute("username", loginBean.getEmail());
				session.setAttribute("yahoo", " yahoo karo");
				System.out.println(loginBean.getEmail());
				System.out.println(session.getAttribute("username"));
				System.out.println(session.getAttribute("yahoo"));
				session.setAttribute("sessID", session.getId());
				session.setMaxInactiveInterval(1000);

				System.out.println(session.getId());
				Cookie cookie = new Cookie("sessID", session.getId());
				cookie.setMaxAge(10000);
				response.addCookie(cookie);
				redirectAttributes.addFlashAttribute("msg", "welcome" + loginBean.getEmail());
				model.addAttribute("msg", "welcome   " + loginBean.getEmail());

				model.addAttribute("ProductBean", new ProductBean());
				
				return "redirect:products";

			} else {
				model.addAttribute("error1", "invalid email");
				return "login";

			}
		} else {
			System.out.println("validation error!!!");
			model.addAttribute("error1", "invalid details");
			return "login";

		}

	}
	// @RequestMapping(value="/login", method = RequestMethod.GET)
	// private void startSession(LoginBean user, HttpServletRequest request,
	// HttpServletResponse response) {
	//
	// }

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model, @ModelAttribute("ProductBean") ProductBean productBean,
			@ModelAttribute("LoginBean") LoginBean user) {

//		System.out.println("session created");
//
//		session.setAttribute("username", user.getEmail());
//		session.setAttribute("yahoo", " yahoo karo");
//		System.out.println(user.getEmail());
//		System.out.println(session.getAttribute("username"));
//		System.out.println(session.getAttribute("yahoo"));
//		session.setAttribute("sessID", session.getId());
//		session.setMaxInactiveInterval(1000);
//
//		System.out.println(session.getId());
//		Cookie cookie = new Cookie("sessID", session.getId());
//		cookie.setMaxAge(10000);
//		response.addCookie(cookie);
		model.addAttribute("stockmap", productBean.getProductStock());
		model.addAttribute("stockprice", productBean.getProductPrice());
		return "/products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addToCart(Model model, @ModelAttribute("ProductBean") ProductBean productBean) {
		System.out.println("adka");
		return "redirect:display";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String show(Model model, @ModelAttribute("ProductBean") ProductBean productBean) {
		System.out.println("show called");
		return "display";
	}

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
