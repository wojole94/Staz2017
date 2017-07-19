package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import pl.woleszko.staz2017.task1.userService.Service.*;

public class UserServiceImpl implements UserService {	
	UserServiceDAO db;
	public UserServiceImpl(UserServiceDAO db){
		this.db=db;
	}
	public User addUser(User user) {
		// TODO Auto-generated method stub
		
		
		return db.put(user);
	}

	public Boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Index " + id);
		return db.delete(id);
	}

	public User editUser(User user) {
		// TODO Auto-generated method stub
		User result = db.edit(user);
		if(result.equals(null)) result = new User(user.getId(),"Brak danych","Brak danych");
		return result;
	}

	public LinkedList<User> getList() {
		// TODO Auto-generated method stub
		
		ArrayList<User> users = db.getTable();
		LinkedList<User> result = new LinkedList<User>();
		for(User usr: users) {
			result.add(usr);
		}
		if (result.isEmpty()) result.add(new User((long) 0,"Brak danych","Brak danych"));
		return result;
		
		

	}

	public User getSingle(Long id) {
		// TODO Auto-generated method stub
		User result = db.get(id);
		if(result.equals(null)) result = new User(id,"Brak danych","Brak danych");
		
		return result;
	}


	
}
