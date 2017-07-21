package pl.woleszko.staz2017.task1.UserServiceMap.UserServiceImplTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import pl.woleszko.staz2017.task1.UserServiceMap.Service.UserServiceMapImpl;
import pl.woleszko.staz2017.task1.userService.Service.*;

public class UserServiceImplTests {

	@Test
	public void testAddUser() {
		
		UserServiceMapImpl userService = new UserServiceMapImpl();
		User user = new User("Kowalski", "kowalski35");
		userService.addUser(user);
		
		User testUser1 = new User("Kowalski", "kowalski35");
		User testValue = userService.addUser(testUser1);
		assertEquals("addUser() method test failure - should return false if login is already in database", null, testValue);
		
		
		User testUser2 = userService.getSingle(user.getId());
		assertNotNull("addUser() method test failure - added record is null", testUser2);
		assertEquals("addUser() method test failure - objects are not the same", true, user.equals(testUser2));
				
	}
	
	@Test
	public void testGetSingle() {
		
		UserServiceMapImpl userService = new UserServiceMapImpl();
		User user = new User("Kowalski", "kowalski35");
		userService.addUser(user);
		
		User testUser = userService.getSingle(user.getId());
		assertNotNull("getSingle() method test failure - method gets null", testUser);
		
		Boolean testValue = user.equals(testUser);
		assertEquals("getSingle() method test failure - pulled record should be the same", true, testValue);		
		
	}
	
	@Test
	public void testGetList() {
		
		UserServiceMapImpl userService = new UserServiceMapImpl();
		User user1 = new User("Kowalski", "kowalski35");
		userService.addUser(user1);
		User user2 = new User("Nowak","nowak23");
		userService.addUser(user2);
		User user3 = new User("Cieslak", "cieslak22");
		userService.addUser(user3);
		
		LinkedList<User> testList = userService.getList();
		
		assertEquals("getList() method failure - should take all added elements from database", 3, testList.size());
			
	}
	
	@Test
	public void testDeleteUser() {
		
		UserServiceMapImpl userService = new UserServiceMapImpl();
		User user = new User("Kowalski", "kowalski35");
		userService.addUser(user);
		
		Boolean testValue1 = userService.deleteUser((long) -1000);
		assertEquals("deleteUser() method test failure - should return false for this argument (-1000)", false, testValue1);
		
		Boolean testValue2 = userService.deleteUser(user.getId());
		assertEquals("deleteUser() method test failure - should return true for this argument (the same as the putted)", true, testValue2);	
		
		User testUser = userService.getSingle(user.getId());
		assertNull("deleteUser() method failure - should delete record at this index", testUser);
				
	}
	
	
	@Test
	public void testEditUser() {
		
		UserServiceMapImpl userService = new UserServiceMapImpl();
		User user = new User("Kowalski", "kowalski35");
		userService.addUser(user);
		
		User testUser1 = userService.getSingle(user.getId());
		testUser1.setLogin("kowalski20");
		testUser1.setName("Nowak");
		User testValue = userService.editUser(testUser1);
		
		assertEquals("editUser() method failure - internal method error", testUser1, testValue);
		
		User testUser2 = userService.getSingle(user.getId());	
		Boolean testValuebool = testUser2.equals(testUser1);
		
		assertEquals("editUser() method failure - no changes in record", true, testValuebool);		
		
	}



	
}
