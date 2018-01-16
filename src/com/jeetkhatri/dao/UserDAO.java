package com.jeetkhatri.dao;

import java.util.List;

import com.jeetkhatri.model.Users;


public interface UserDAO {
	
	public boolean loginUser(String email, String password);
}

