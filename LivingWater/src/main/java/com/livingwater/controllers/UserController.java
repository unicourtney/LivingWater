package com.livingwater.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView loginPage(){
		ModelAndView view = new ModelAndView("login");
		return view;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map){
		ModelAndView view = new ModelAndView("index");
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		System.out.println("USER ID: " + user_id + "\nPASSWORD: " + password);
		return view;
	}
	
	@RequestMapping(value="/inventory", method = RequestMethod.GET)
	public ModelAndView inventoryPage(){
		ModelAndView view = new ModelAndView("index");
		return view;
	}
}
