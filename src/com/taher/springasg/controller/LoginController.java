package com.taher.springasg.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class LoginController {
	@Autowired
	LoginValidator logValidator;
	@Autowired
	LoginBean login;

	@InitBinder("LoginBean")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(logValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginBean",login);
		return mav;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGET(Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginBean", login);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") /* @Validated */ LoginBean loginBean,
			final RedirectAttributes redirectAttributes, BindingResult result, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
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

				model.addAttribute("productBean", new ProductBean());

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


}
