package com.nkart.shoppingcart.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkart.shoppingcart.dao.CartDAO;
import com.nkart.shoppingcart.domain.Cart;
@Transactional
@SuppressWarnings("deprecation")
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl() {

	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Cart> getAllCarts(String userID) 
	{
		String hql = "from Cart where userID=" + "'" + userID + "'  and status = " + "'N'";
		@SuppressWarnings({ "rawtypes" })
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Transactional
	public boolean saveCart(Cart cart) {
		
		/*cart.setId(getMaxId());*/
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Long getTotalAmount(String userID) {
		
		String hql = "select sum(price) from Cart where userID=" + "'" + userID + "' " + "  and status = " + "'N'";

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Long) query.uniqueResult();
	}

	

	public Cart get(String id) {
	
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
	}

	public boolean deleteCart(Cart cart) {
		
		cart.setStatus('X');
		return updateCart(cart);
	}

	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
