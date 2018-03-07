package com.jeetkhatri.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeetkhatri.model.Users;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Users> loginUser(String email, String password) {
		System.out.println(password);
		return sessionFactory.getCurrentSession().createCriteria(Users.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.add(Restrictions.eq("isAvailable", "Y")).list(); 
	}

	@Override
	public void addUser(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
	}
}
