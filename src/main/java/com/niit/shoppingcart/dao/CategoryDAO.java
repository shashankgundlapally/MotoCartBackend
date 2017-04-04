package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO
{
	//declare the methods related to CRUD operations
	
	//get all category
		//access_specifiers return_type method_name(parameter_list) throws exception_list
	public List<Category> getAllCategories();
	
	//create category
	public boolean createCategory(Category category);
	
	
	//update category
	public boolean updateCategory(Category category);
	
	
	
	
	//delete category
	public boolean deleteCategory(Category category);
	
	
	//delete category by name
	public boolean deleteCategoryByName(String name);
	
	//delete category by id
	public boolean deleteCategoryById(int id);
	
	
	//get category by id
	public Category getCategoryById(int id);
	
	
	
	//get category by name
	public Category getCategoryByName(String name);
	
	
	/*public boolean save(Category category);
	public boolean delete(int id);
	public Category get(int id);
	public List<Category> list();
*/
}
