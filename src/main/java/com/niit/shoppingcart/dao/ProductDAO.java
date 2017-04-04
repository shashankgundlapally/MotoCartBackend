package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO 
{
	public List<Product> getAllProducts();
	
	public boolean createProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public Product getProductById(int id);
	
	public Product getProductByName(int name);
	
	
	
}
