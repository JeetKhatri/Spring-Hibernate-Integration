package com.jeetkhatri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetkhatri.bean.BookBean;
import com.jeetkhatri.dao.*;
import com.jeetkhatri.model.*;

@Service("bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addBook(Books book) {
		bookDAO.addBook(book);
	}
	
	public List<Books> listOfBooks() {
		return bookDAO.listOfBooks();
	}

	@Override
	public List<Books> searchBookByName(String name) {
		return bookDAO.searchBookByName(name);
	}

	@Override
	public void deleteBook(Books book) {
		bookDAO.deleteBook(book);
	}

	@Override
	public Books getBookDetails(String id) {
		return bookDAO.getBookDetails(id);
	}

	@Override
	public void editBook(Books book) {
		bookDAO.editBook(book);
	}

}
