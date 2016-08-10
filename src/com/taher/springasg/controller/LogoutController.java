package com.taher.springasg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taher.springasg.model.LoginBean;

@Controller
public class LogoutController {
	@Autowired
	LoginBean login;
	@RequestMapping(value="/logout" ,method=RequestMethod.GET)
	public ModelAndView logout(Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginBean", login);
		return mav;
	}
}
