package com.jeetkhatri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetkhatri.dao.EmployeeDao;
import com.jeetkhatri.dao.UserDAO;
import com.jeetkhatri.model.Users;
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<Users> loginUser(String email, String password) {
		return userDAO.loginUser(email, password);
	}

}
