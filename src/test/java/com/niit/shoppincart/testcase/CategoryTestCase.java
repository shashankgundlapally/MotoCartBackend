package com.niit.shoppincart.testcase;

import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

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
		context.scan("com.niit");
		context.refresh();
		

		category= (Category)context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		
	}
	
	/*@Test
	public void createCategoryTestCase()
	{
		category.setId(77);
		category.setName("Ssssss");
		category.setDescription("This is ss Category ");
		
	boolean flag = categoryDAO.createCategory(category);
		
		System.out.println("Done");
		
		//compare what you are expecting vs what you are getting from the save method
		//Assert.assertEquals("createCategoryTestCase",true,flag);
		 assertEquals("createCategoryTestCase", true, flag);
		
		
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId(141);
		category.setName("Normal Tv");
		category.setDescription("This is Television Category");
		
		boolean flag = categoryDAO.updateCategory(category);
		
		assertEquals("updateCategoryTestCase",true,flag);
		System.out.println("update success");
	}

	@Test
	public void deleteCategoryTestCase()
	{
		//category.setId(3);
		category.setName("vvsfs");
		boolean flag = categoryDAO.deleteCategory(category);
		
		//Assert.assertEquals("deleteCategoryTestCase" ,true,flag);
		assertEquals("deleteCategoryTestCase", true, flag);;
	}
	
	
	
	
	
	
	
	@Test
	public void getAllCategoriesTestCase()
	{
	int recordsFromDAO=	categoryDAO.getAllCategories().size();
		assertEquals("getAllCategoriesTestCase",5, recordsFromDAO);
		
		
		
	}
	
	
	
	
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
	}
	
	*/

}





















