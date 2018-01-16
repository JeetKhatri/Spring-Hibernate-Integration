package com.jeetkhatri.dao;

import java.util.List;

import com.jeetkhatri.model.Users;


public interface UserDAO {
	
	public List<Users> loginUser(String email, String password);
}

