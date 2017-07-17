package pl.woleszko.staz2017.task1.UserServiceDB;

import java.util.LinkedList;

import pl.woleszko.staz2017.task1.UserServiceDB.Service.UserServiceImpl;
import pl.woleszko.staz2017.task1.userService.Service.User;


public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserServiceImpl userService = new UserServiceImpl();
		LinkedList<User> list = userService.getList();
		
		for(User usr : list) {
			System.out.println("#. " + usr.getLogin() + " " + usr.getName() );
		}
		
	}

}
