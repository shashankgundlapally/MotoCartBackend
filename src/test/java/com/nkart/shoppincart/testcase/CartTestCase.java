/*package com.nkart.shoppincart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nkart.shoppingcart.dao.CartDAO;
import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.domain.Cart;
import com.nkart.shoppingcart.domain.Category;

public class CartTestCase 
{

	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.nkart");
		context.refresh();
		

		cart= (Cart)context.getBean("cart");
		cartDAO = (CartDAO) context.getBean("cartDAO");
				
	}
	@Test
	public void createCartTestCase()
	{
		cart.setProductName("");
		cart.setPrice(10000);
		cart.setQuantity(1);
		
		cart.setUserID("");
		
	boolean flag = cartDAO.createCategory(cart);
		
		System.out.println("Done");
		
		//compare what you are expecting vs what you are getting from the save method
		//Assert.assertEquals("createCategoryTestCase",true,flag);
		 assertEquals("createCategoryTestCase", true, flag);
		
		
	}

}
*/