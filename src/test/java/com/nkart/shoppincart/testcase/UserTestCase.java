package com.nkart.shoppincart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.User;

public class UserTestCase
{
@Autowired
 private static User user;

@Autowired
private static UserDAO userDAO;
@BeforeClass
public static void initialize()
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.nkart");
	context.refresh();
	
	user =(User) context.getBean("user");
	userDAO= (UserDAO) context.getBean("userDAO");
}

@Test
public void createUserTestCase()
{
	
	user.setName("sai");
	user.setPassword("sai");
	user.setEmail("sai@gmail.com");
	user.setContact("154548");
	user.setRole("user");
	
	boolean flag= userDAO.createUser(user);
	assertEquals("createUserTestCase", true, flag);
	
}

/*@Test
public void updateUserTestCase()
{
		user.setId("02");
		
		user.setName("pawan");
		user.setPassword("pawan234");
		
		user.setContact("12345678");
		user.setRole("user");
		user.setEmail("pawan@gmail.com");
		
		boolean flag= userDAO.updateUser(user);
		assertEquals("updateUserTestCase", true, flag);
}




@Test
public void validateCredentialsTestCase()
{
	boolean flag=userDAO.validate("10", "akhil");
	assertEquals("vlaidateCredentialsTestCase", true, flag);
}

@Test
public void deleteUserTestCase()
{
	user.setId("11");
	boolean flag=userDAO.deleteUser(user);
	assertEquals("deleteUserTestCase", true, flag);
}*/

/*@Test
public void getAllUsersTestCase()
{
	int noofusers= userDAO.getAllUsers().size();
	assertEquals("getAllUsersTestCase", 1, noofusers);
}
*/

}


















