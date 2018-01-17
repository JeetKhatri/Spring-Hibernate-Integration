package com.jeetkhatri.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jeetkhatri.model.Books;
import com.jeetkhatri.model.Employee;
import com.jeetkhatri.model.Users;
import com.jeetkhatri.util.GenrateMathodsUtils;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBook(Books book) {
		book.setId(GenrateMathodsUtils.getRandomString(15));
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	@SuppressWarnings("unchecked")
	public List<Books> listOfBooks() {
		return (List<Books>) sessionFactory.getCurrentSession()
				.createCriteria(Books.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Books> searchBookByName(String name) {
		return (List<Books>) sessionFactory.getCurrentSession()
				.createCriteria(Books.class).add(Restrictions.eq("name", name))
				.list();
	}

	@Override
	public void deleteBook(Books book) {
		Books b = (Books) sessionFactory.getCurrentSession().createCriteria(Books.class)
				.add(Restrictions.eq("id",book.getId())).uniqueResult();
		sessionFactory.getCurrentSession().delete(b);
	}

	@Override
	public Books getBookDetails(String id) {
		return (Books) sessionFactory.getCurrentSession().get(Books.class, id);
	}

	@Override
	public void editBook(Books book) {
		sessionFactory.getCurrentSession().update(book);
	}
}
