package com.niit.shoppincart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase 
{

@Autowired
private static Product product;

@Autowired
private static ProductDAO productDAO;

@BeforeClass
public static void initialize()
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	product = (Product) context.getBean("product");
	productDAO = (ProductDAO) context.getBean("productDAO");
}

/*@Test
public void createProductTestCase()
{
	product.setId(30);
	product.setName("Nokia");
	product.setDescription("black");
	product.setCategory_id("7");
	product.setSupplier_id("22");
	
	boolean flag = productDAO.createProduct(product);
	assertEquals("createProductTestCase", true, flag);
}

@Test
public void updateProductTestCase()
{
	product.setId(30);
	product.setName("Nokia 3310");
	product.setDescription("white");
	product.setCategory_id("7");
	product.setSupplier_id("22");
	
	boolean flag = productDAO.updateProduct(product);
	assertEquals("updateProductTestCase", true, flag);
}
@Test
public void deleteProductTestCase()
{
	product.setId(30);
	boolean flag=productDAO.deleteProduct(product);
	assertEquals("deleteProductTestCase", true, flag);
}

@Test
public void getAllProductTestCase()
{
	int noofpro=productDAO.getAllProducts().size();
	assertEquals("getAllProductsTestCase", 1, noofpro);
}*/
}
