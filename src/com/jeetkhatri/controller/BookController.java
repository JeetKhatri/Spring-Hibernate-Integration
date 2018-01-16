package com.jeetkhatri.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jeetkhatri.bean.UserBean;
import com.jeetkhatri.model.Books;
import com.jeetkhatri.service.BookService;

/***
 * 
 * @author JeetKhatri
 *
 */

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("command") Books book,
			BindingResult result) {
		bookService.addBook(book);
		request.setAttribute("msg", "Book successfully Inserted");
		return new ModelAndView("adminHomePage");
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public ModelAndView searchBook(@ModelAttribute("command") Books book,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books",  (bookService.searchBookByName(book.getName())));
		return new ModelAndView("searchBookPage", model);
	}

	@RequestMapping(value = "/addBookPage", method = RequestMethod.GET)
	public ModelAndView addBookPage(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("addBookPage");
	}
	
	@RequestMapping(value = "/listBookPage", method = RequestMethod.GET)
	public ModelAndView listBook(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books",  (bookService.listOfBooks()));
		return new ModelAndView("listBookPage", model);
	}
	
	@RequestMapping(value = "/searchBookPage", method = RequestMethod.GET)
	public ModelAndView searchBook(
			@ModelAttribute("command") UserBean userBean, BindingResult result) {
		return new ModelAndView("searchBookPage");
	}
	
	/*private List<BookBean> prepareListofBean(List<Books> books) {
		List<BookBean> beans = null;
		if(books != null && !books.isEmpty()){
			beans = new ArrayList<BookBean>();
			BookBean bean = null;
			for(Books book : books){
				bean = new BookBean();
				bean.setAuthor(book.getAuthor());
				bean.setId(book.getId());
				bean.setName(book.getName());
				bean.setPrice(book.getPrice());
				beans.add(bean);
			}
		}
		return beans;
	}*/
}