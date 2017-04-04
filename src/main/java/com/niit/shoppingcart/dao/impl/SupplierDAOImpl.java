package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSuppliers() 
	{
	return sessionFactory.getCurrentSession().createQuery("from Supplier").list();	
	}

	public boolean createSupplier(Supplier supplier) 
	{
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			}
		catch (Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) 
	{
				
		try{
			/*if(supplier.getId() !=null)
				supplier1 = getSupplierById(supplier.getId());
			else if (supplier.getName() !=null)
				supplier1 = getSupplierByName(supplier.getName());*/
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			}
		catch (Exception e)
			{
			e.printStackTrace();
			return false;
			}
	}

	public Supplier getSupplierById(int id) 
	{
	return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id='"+id+"'").uniqueResult();	
	}

	public Supplier getSupplierByName(int name) 
	{
		
	return	(Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name='"+name+"'").list().get(0);
			
	}

}
