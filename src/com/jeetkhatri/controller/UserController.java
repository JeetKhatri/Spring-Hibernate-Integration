package com.jeetkhatri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeetkhatri.bean.UserBean;
import com.jeetkhatri.model.Users;
import com.jeetkhatri.service.EmployeeService;
import com.jeetkhatri.service.UserService;

/***
 * 
 * @author JeetKhatri
 *
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUsers(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		System.out.println("control at userController.java");
		System.out.println(userBean.getEmail() + " " + userBean.getPassword());

		userService.loginUser(userBean.getEmail(),userBean.getPassword());

		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView addEmployee(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("loginPage");
	}
}
