package com.taher.springasg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	@RequestMapping(value="/" ,method  = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String validate(ModelMap model , HttpServletRequest request){
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		if("taher".equalsIgnoreCase(username) && "1234".equalsIgnoreCase(pwd))
		{
		 return "firstpage";
	}
		return "login";
		}

}
