package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;
@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() 
	{
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean createProduct(Product product) 
	{
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
			}
		catch (Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			}
		catch (Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
			/*if (product.getId() != null)
				product1  = getProductById(product.getId());
			else if (product.getName() != null)
				product1 = getProductByName(product.getName());*/
			sessionFactory.getCurrentSession().delete(product);
			return true;
			}
		catch (Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id='"+id+"'").uniqueResult();
	}

	public Product getProductByName(int name) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where name='"+name+"'").list().get(0);
	}

}
