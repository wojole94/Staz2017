package pl.woleszko.staz2017.task1.UserServiceMap.Service;

import pl.woleszko.staz2017.task1.userService.Service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;



public class UserServiceImpl implements UserService {
	private HashMap<Long,User> db;	
	public UserServiceImpl() {
		db = new HashMap<Long,User>();
		
	}
	
	public void addUser(User user) {
		
	}
	
	public void editUser(Long id) {
		
	}
	
	public void deleteUser(Long id) {
		
	}
	
	public User getSingle(Long id) {
		return (User) db.get(id);
	}
	
	public ArrayList<User> getList(){
		Set<Long> keys = db.keySet();
		ArrayList<User> users = new ArrayList<User>();
		for(Long idx : keys) {
			users.add(getSingle(idx));
		}
		return users;
	}
}
