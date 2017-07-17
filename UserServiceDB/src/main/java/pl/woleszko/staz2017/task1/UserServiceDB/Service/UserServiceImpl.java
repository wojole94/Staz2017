package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.List;
import java.util.LinkedList;

import pl.woleszko.staz2017.task1.userService.Service.*;

public class UserServiceImpl implements UserService {
	UserServiceDAO db;
	public UserServiceImpl(){
		db = new UserServiceDAO();
	}
	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
		db.put(user);
		return null;
	}

	public Boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean editUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<User> getList() {
		return null;
		// TODO Auto-generated method stub

	}

	public User getSingle(Long id) {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	
}
