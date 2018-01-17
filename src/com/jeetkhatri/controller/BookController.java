package com.jeetkhatri.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jeetkhatri.bean.BookBean;
import com.jeetkhatri.bean.EmployeeBean;
import com.jeetkhatri.bean.MultiFileUpload;
import com.jeetkhatri.bean.UserBean;
import com.jeetkhatri.model.Books;
import com.jeetkhatri.model.Employee;
import com.jeetkhatri.model.Users;
import com.jeetkhatri.service.BookService;
import com.jeetkhatri.util.GenrateMathodsUtils;

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
	public ModelAndView addBook(@ModelAttribute("command") BookBean bookBean,
			@ModelAttribute("multiFileUpload") MultiFileUpload multiFileUpload,
			BindingResult bindingResult, Model model) throws IOException {

		bookBean.setId(GenrateMathodsUtils.getRandomString(15));
		String absoluteDiskPath = request.getSession().getServletContext().getRealPath("files");

		List<MultipartFile> files = multiFileUpload.getMultiUploadedFileList();
		
		for (MultipartFile multipartFile : files) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream output = null;
			File outputfile = null;
			String fileName = multipartFile.getOriginalFilename();
			String extensionOfFileName = fileName.substring(
					fileName.indexOf(".") + 1, fileName.length());
			outputfile = new File(absoluteDiskPath + File.separator
					+ bookBean.getId() + ".pdf");
			InputStream inputStream = multipartFile.getInputStream();

			if (null != extensionOfFileName
					&& extensionOfFileName.equalsIgnoreCase("pdf")) {
				if (!outputfile.isDirectory()) {
					try {
						output = new FileOutputStream(outputfile);
						IOUtils.copy(inputStream, output);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						baos.close();
						output.close();
					}
				}
				bookService.addBook(prepareModel(bookBean));
				request.setAttribute("msg", "Book successfully Inserted");
			} else {
				System.out.println("Unknown file extension"
						+ extensionOfFileName);
				request.setAttribute("msg",
						"Unknown file extension. Please upload files in PDF format");
			}

		}

		return new ModelAndView("adminHomePage");
	}

	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public ModelAndView searchBook(@ModelAttribute("command") Books book,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books", (bookService.searchBookByName(book.getName())));
		return new ModelAndView("searchBookPage", model);
	}

	@RequestMapping(value = "/addBookPage", method = RequestMethod.GET)
	public ModelAndView addBookPage(@ModelAttribute("command") Books bookBean,
			BindingResult result) {
		return new ModelAndView("addBookPage");
	}

	@RequestMapping(value = "/listBookPage", method = RequestMethod.GET)
	public ModelAndView listBook(@ModelAttribute("command") Books bookBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("books", (bookService.listOfBooks()));
		return new ModelAndView("listBookPage", model);
	}

	@RequestMapping(value = "/searchBookPage", method = RequestMethod.GET)
	public ModelAndView searchBookPage(
			@ModelAttribute("command") Books bookBean, BindingResult result) {
		return new ModelAndView("searchBookPage");
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		Books book = prepareModel(bookBean);
		bookService.deleteBook(book);
		return new ModelAndView("redirect:/listBookPage.html");
	}

	@RequestMapping(value = "/editBookPage", method = RequestMethod.GET)
	public ModelAndView editBookPage(
			@ModelAttribute("command") BookBean bookBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("book",
				prepareBean(bookService.getBookDetails(bookBean.getId())));
		return new ModelAndView("editBookPage", model);
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.POST)
	public ModelAndView editBook(@ModelAttribute("command") Books book,
			BindingResult result) {
		bookService.editBook(book);
		request.setAttribute("msg", "Book successfully Edited");
		return new ModelAndView("adminHomePage");
	}

	private Books prepareModel(BookBean bookBean) {
		Books book = new Books();
		book.setAuthor(bookBean.getAuthor());
		book.setId(bookBean.getId());
		book.setName(bookBean.getName());
		book.setPrice(bookBean.getPrice());
		return book;
	}

	private BookBean prepareBean(Books book) {
		BookBean bookBean = new BookBean();
		bookBean.setAuthor(book.getAuthor());
		bookBean.setId(book.getId());
		bookBean.setName(book.getName());
		bookBean.setPrice(book.getPrice());
		return bookBean;
	}

	/*
	 * private List<BookBean> prepareListofBean(List<Books> books) {
	 * List<BookBean> beans = null; if(books != null && !books.isEmpty()){ beans
	 * = new ArrayList<BookBean>(); BookBean bean = null; for(Books book :
	 * books){ bean = new BookBean(); bean.setAuthor(book.getAuthor());
	 * bean.setId(book.getId()); bean.setName(book.getName());
	 * bean.setPrice(book.getPrice()); beans.add(bean); } } return beans; }
	 */
}