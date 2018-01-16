package com.jeetkhatri.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeetkhatri.model.Users;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean loginUser(String email, String password) {
		Query q = sessionFactory.getCurrentSession().createQuery("select id from users where email = :e and password = :p");
		q.setParameter("e", email);
		q.setParameter("p", password);
		List list=q.list();  
		System.out.println(list.size());
		return true;
	}

}
