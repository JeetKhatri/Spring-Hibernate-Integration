package com.jeetkhatri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeetkhatri.bean.EmployeeBean;
import com.jeetkhatri.bean.UserBean;
import com.jeetkhatri.model.Employee;
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
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUsers(@ModelAttribute("command") Users user,
			BindingResult result) {
		System.out.println("control at userController.java");
		List<Users> users = userService.loginUser(user.getEmail(),
				user.getPassword());
		if (users.size() == 0)
			return new ModelAndView("loginPage");
		else if (users.get(0).getIsAdmin().equalsIgnoreCase("Y")){
			request.getSession().setAttribute("user",users.get(0));
			return new ModelAndView("adminHomePage");
		}else{
			request.getSession().setAttribute("user",users.get(0));
			return new ModelAndView("userHomePage");
		}
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView addEmployee(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public ModelAndView homeAdmin(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("adminHomePage");
	}
	
	@RequestMapping(value = "/homeUser", method = RequestMethod.GET)
	public ModelAndView homeUser(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("userHomePage");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		request.getSession().invalidate();
		return new ModelAndView("loginPage");
	}
	private Users prepareModel(UserBean userBean) {
		Users user = new Users();
		user.setEmail(userBean.getEmail());
		user.setId(userBean.getId());
		user.setIsAdmin(userBean.getIsAdmin());
		user.setIsAvailable(userBean.getIsAvailable());
		user.setName(userBean.getName());
		user.setPassword(userBean.getPassword());
		return user;
	}

	private UserBean getBean(List<Users> users) {

		UserBean bean = new UserBean();
		bean.setId(users.get(0).getId());
		bean.setName(users.get(0).getName());
		bean.setEmail(users.get(0).getEmail());
		bean.setIsAdmin(users.get(0).getIsAdmin());
		bean.setIsAvailable(users.get(0).getIsAvailable());
		return bean;
	}
}
