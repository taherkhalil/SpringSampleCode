package com.taher.springasg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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
	public String submit(Model model, @ModelAttribute("loginBean") /*@Validated*/ LoginBean loginBean,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		System.out.println("asd");
		logValidator.validate(loginBean, result);
		System.out.println("result.hasErrors() : " + result.hasErrors());
		if (!result.hasErrors()) {
			if (loginBean.getEmail().equals("taher@gmail.com") && loginBean.getPassword().equals("1234")) {
				redirectAttributes.addFlashAttribute("msg", "welcome" + loginBean.getEmail());
				model.addAttribute("msg", "welcome" + loginBean.getEmail());

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

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model, @ModelAttribute("ProductBean") ProductBean productBean) {

		model.addAttribute("stockmap", productBean.getProductStock());
		return "/products";
	}
}
