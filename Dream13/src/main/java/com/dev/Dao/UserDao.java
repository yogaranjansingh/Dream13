package com.dev.Dao;

import com.dev.Model.LoginRequest;
import com.dev.Model.RegistertionRequest;
import com.dev.Model.User;

public interface UserDao {
	
	public void register(RegistertionRequest request);
	public User login(LoginRequest request);

}
