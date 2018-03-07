package com.jeetkhatri.service;

import java.util.List;

import com.jeetkhatri.model.*;

/**
 * @author JeetKhatri
 *
 */
public interface UserService {
	
	public List<Users> loginUser(String email, String password);

	public void addUser(Users users);
}

