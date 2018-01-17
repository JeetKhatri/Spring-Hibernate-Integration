package com.jeetkhatri.service;

import java.util.List;

import com.jeetkhatri.bean.BookBean;
import com.jeetkhatri.model.Books;
import com.jeetkhatri.model.Employee;
import com.jeetkhatri.model.Users;

/**
 * @author JeetKhatri
 *
 */
public interface BookService {
	
	public void addBook(Books book);
	public List<Books> listOfBooks();
	public List<Books> searchBookByName(String name);
	public void deleteBook(Books book);
	public Books getBookDetails(String id);
	public void editBook(Books book);
}



