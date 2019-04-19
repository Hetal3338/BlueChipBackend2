package com.ecomm.dao;

import com.ecomm.model.UserDetail;

public interface UserDAO 
{
	public boolean registerUser(UserDetail user);
	public UserDetail getUserDetail(String username);
	public boolean updateUser(UserDetail user);
}
