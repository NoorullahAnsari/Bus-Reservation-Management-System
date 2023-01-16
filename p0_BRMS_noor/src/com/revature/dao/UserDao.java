package com.revature.dao;

import com.revature.model.User;

public interface UserDao {
	
	public abstract void addUserDetails();
	
	public abstract void updateUserDetails(User u);
	
	public abstract void deleteUserDetails(User u);
	
	public abstract void displayUserDetails();

	
}

