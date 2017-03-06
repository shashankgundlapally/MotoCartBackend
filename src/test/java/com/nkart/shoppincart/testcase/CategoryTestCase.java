package com.nkart.shoppincart.testcase;

import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.domain.Category;

public class CategoryTestCase {

	@Autowired
	 static Category category;
	@Autowired
	 static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.nkart");
		context.refresh();
		

		category= (Category)context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		
	}
	
	@Test
	public void createCategoryTestCase()
	{
		category.setId("143");
		category.setName("Shoes");
		category.setDescription("This is Men Category ");
		
	boolean flag = categoryDAO.createCategory(category);
		
		System.out.println("Done");
		
		//compare what you are expecting vs what you are getting from the save method
		//Assert.assertEquals("createCategoryTestCase",true,flag);
		 assertEquals("createCategoryTestCase", true, flag);
		
		
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("141");
		category.setName("Normal Tv");
		category.setDescription("This is Television Category");
		
		boolean flag = categoryDAO.updateCategory(category);
		
		assertEquals("updateCategoryTestCase",true,flag);
		System.out.println("update success");
	}

	
	
	
	
	
	
	
	
	/*@Test
	public void getAllCategoriesTestCase()
	{
	int recordsFromDAO=	categoryDAO.getAllCategories().size();
		assertEquals("getAllCategoriesTestCase",9, recordsFromDAO);
		
		
		
	}*/
	
	/*@Test
	public void deleteCategoryTestCase()
	{
		//category.setId("3");
		category.setName("vvsfs");
		boolean flag = categoryDAO.deleteCategory(category);
		
		//Assert.assertEquals("deleteCategoryTestCase" ,true,flag);
		assertEquals("deleteCategoryTestCase", true, flag);;
	}
	
	/*
	@Test
	public void getCategoryByIdTestCase()
	{
		category =categoryDAO.getCategoryById("111");
		boolean flag = categoryDAO.deleteCategory(category);
		assertEquals("getCategoryTestCase" ,true,flag);
		
		
	}
	@Test
	public void deleteCategoryByNameTestCase()
	{
		
		boolean flag = categoryDAO.deleteCategoryByName("Acer");
		
		assertEquals("deleteCategoryByNameTestCase" ,true,flag);
	}
	
	@Test
	public void deleteCategoryByIdTestCase()
	{
		
		boolean flag = categoryDAO.deleteCategoryById("57");
		
		assertEquals("deleteCategoryByIdTestCase" ,true,flag);
	}*/
	
	

}





















