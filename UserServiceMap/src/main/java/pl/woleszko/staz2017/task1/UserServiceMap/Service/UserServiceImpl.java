package pl.woleszko.staz2017.task1.UserServiceMap.Service;

import pl.woleszko.staz2017.task1.userService.Service.User;
import pl.woleszko.staz2017.task1.userService.Service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;
import java.util.Set;



public class UserServiceImpl implements UserService {
	private HashMap<Long,User> db;	
	public UserServiceImpl() {
		db = new HashMap<Long,User>();
		
	}
	/**
	 * 
	 * 
	 * @return Returns false if record with the same login exists in database
	 */
	
	
	public Boolean addUser(User user) {
		LinkedList<User> list = getList();
		
		for(User ex : list ) {
			if (ex.getLogin().equals(user.getLogin())) return false;
		}
		
		while (db.containsKey(user.getId())) {		
			user = new User(user.getName(),user.getLogin());			
		}
		
		db.put(user.getId(),user);		
		return true;
	}
	
	public Boolean editUser(User user) {
		
		if(!deleteUser(user.getId())) return false;
		if(!addUser(user)) return false;
		
		return true;
	}
	
	/**
	 * 
	 * 
	 * @return Returns false if record at this index wasn't in database
	 */
	
	public Boolean deleteUser(Long idx) {
		
		if(!db.containsKey(idx)) return false;
		
		db.remove(idx);
		
		return true;
	}
	
	public User getSingle(Long idx) {
		return (User) db.get(idx);
	}
	
	public LinkedList<User> getList(){
		Set<Long> keys = db.keySet();
		LinkedList<User> users = new LinkedList<User>();
		for(Long idx : keys) {
			users.add(getSingle(idx));
		}
		return users;
	}
}
