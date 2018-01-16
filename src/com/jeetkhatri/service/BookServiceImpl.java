package com.jeetkhatri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	

}
