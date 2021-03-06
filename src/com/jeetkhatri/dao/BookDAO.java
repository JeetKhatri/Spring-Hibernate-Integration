package com.jeetkhatri.dao;

import java.util.List;

import com.jeetkhatri.model.Books;

public interface BookDAO {

	public void addBook(Books book);

	public List<Books> listOfBooks();

	public List<Books> searchBookByName(String name);

	public void deleteBook(Books book);

	public Books getBookDetails(String id);

	public void editBook(Books book);

}
