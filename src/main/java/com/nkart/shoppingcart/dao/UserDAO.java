package com.nkart.shoppingcart.dao;

import java.util.List;

import com.nkart.shoppingcart.domain.User;

public interface UserDAO 
{
	public List<User> getAllUsers();

	public boolean  createUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User getUserById(String id);
	
	public User getUserByName(String name);
	
	public User validate(String id,String password);
	
}
