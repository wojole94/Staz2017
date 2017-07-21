package pl.woleszko.staz2017.task1.UserServiceMap.Service;

import pl.woleszko.staz2017.task1.userService.Service.User;
import pl.woleszko.staz2017.task1.userService.Service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;



public class UserServiceMapImpl implements UserService {
	private HashMap<Long, User> db;	
	private AtomicLong index = new AtomicLong(0);
	public UserServiceMapImpl() {
		db = new HashMap<Long,User>();
		
	}
	/**
	 * 
	 * 
	 * @return Returns false if record with the same login exists in database
	 */
	
	
	public User addUser(User user) {
		LinkedList<User> list = getList();
		
		for(User ex : list ) {
			if (ex.getLogin().equals(user.getLogin())) return null;
		}
		Long id = user.getId();
		
		if(id == null) {
			Long newId = index.incrementAndGet();
			user.setId(newId);
		}
		
		db.put(user.getId(),user);		
		return user;
	}
	
	public User editUser(User user) {
		
		if(!deleteUser(user.getId())) return null;
		if(addUser(user).equals(null)) return null;
		
		return user;
	}
	
	/**
	 * 
	 * 
	 * @return Returns false when record at this index wasn't in database
	 */
	
	public Boolean deleteUser(Long idx) {
		
		if(!db.containsKey(idx)) return false;
		
		db.remove(idx);
		
		return true;
	}
	
	public User getSingle(Long idx) {
		if(!db.containsKey(idx)) return null;
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
