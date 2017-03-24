package com.nkart.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nkart.shoppingcart.dao.CartDAO;
import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.dao.ProductDAO;
import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.dao.impl.CartDAOImpl;
import com.nkart.shoppingcart.dao.impl.CategoryDAOImpl;
import com.nkart.shoppingcart.dao.impl.ProductDAOImpl;
import com.nkart.shoppingcart.dao.impl.SupplierDAOImpl;
import com.nkart.shoppingcart.dao.impl.UserDAOImpl;
import com.nkart.shoppingcart.domain.Cart;
import com.nkart.shoppingcart.domain.Category;
import com.nkart.shoppingcart.domain.Product;
import com.nkart.shoppingcart.domain.Supplier;
import com.nkart.shoppingcart.domain.User;

@Configuration
@ComponentScan("com.nkart.shoppingcart")

@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
         System.out.println("data base is connected......................!");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		System.out.println("Session Factory: " + sessionBuilder.buildSessionFactory());
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Tracnstion: " + transactionManager);
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
			
	}
	
	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory){
		return  new CategoryDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory){
		return  new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory){
		return  new CartDAOImpl(sessionFactory);
	}
	

}
