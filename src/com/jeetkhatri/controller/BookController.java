package com.jeetkhatri.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.jeetkhatri.dao.BookDAO;
import com.jeetkhatri.model.Books;
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
public class BookController {

	@Autowired
	private BookDAO bookdao;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView loginUsers(@ModelAttribute("command") Books book,
			BindingResult result) {
		bookdao.addBook(book);
		request.setAttribute("msg", "Book successfully Inserted");
		return new ModelAndView("adminHomePage");
	}

	@RequestMapping(value = "/addBookPage", method = RequestMethod.GET)
	public ModelAndView addBook(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("addBookPage");
	}
	
	@RequestMapping(value = "/listBookPage", method = RequestMethod.GET)
	public ModelAndView listBook(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("listBookPage");
	}
	
	@RequestMapping(value = "/searchBookPage", method = RequestMethod.GET)
	public ModelAndView searchBook(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("searchBookPage");
	}
}