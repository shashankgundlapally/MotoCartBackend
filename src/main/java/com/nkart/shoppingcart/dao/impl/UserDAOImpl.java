package com.nkart.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	public boolean createUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			User user1 = null;
			if (user.getId() != null)
				user1 = getUserById(user.getId());
			else if (user.getName() != null)
				user1 = getUserByName(user.getName());
			sessionFactory.getCurrentSession().delete(user1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where id='" + id + "'").uniqueResult();
	}

	public User getUserByName(String name) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where name='" + name + "'").list().get(0);
	}

	public User validate(String id, String password)
	{
		// select * from User where id='' and password=''
		String hql="from User where id='"+id+"' and password ='"+password+"'";
		if(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()==null)
			{
			return null;
			}
		else
			return (User) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

}
