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
	/**
	 * 
	 * 
	 * @return Returns false if record with the same login exists in database
	 */
	
	
	public Boolean addUser(User user) {
		ArrayList<User> list = getList();
		
		for(User ex : list ) {
			if (ex.getLogin().equals(user.getLogin())) return false;
		}
		
		while (db.containsKey(user.getIndex())) {		
			user = new User(user.getName(),user.getLogin());			
		}
		
		db.put(user.getIndex(),user);		
		return true;
	}
	
	public Boolean editUser(User user) {
		
		if(!deleteUser(user.getIndex())) return false;
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
	
	public ArrayList<User> getList(){
		Set<Long> keys = db.keySet();
		ArrayList<User> users = new ArrayList<User>();
		for(Long idx : keys) {
			users.add(getSingle(idx));
		}
		return users;
	}
}
