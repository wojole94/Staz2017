package pl.woleszko.staz2017.task1.UserServiceMap.Service;

import pl.woleszko.staz2017.task1.userService.Service.*;
import java.util.ArrayList;

import pl.woleszko.staz2017.task1.UserServiceMap.DatabaseAccess.*;

public class UserServiceImpl implements UserService {
	private DatabaseAccessObject dao = new DatabaseAccessObject();
	
	public void addUser(User user) {
		
	}
	
	public void editUser(Long id) {
		
	}
	
	public void deleteUser(Long id) {

	}
	
	public User showSingle(Long id) {
		return null;
	}
	
	public ArrayList<User> showList(){
		return null;
	}
}
