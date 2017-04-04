package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO 
{
	public List<User> getAllUsers();

	public boolean  createUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User getUserById(int id);
	
	public User getUserByName(String name);
	
	public User validate(String name,String password);
	
}
