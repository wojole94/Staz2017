package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.List;
import java.util.LinkedList;

import pl.woleszko.staz2017.task1.userService.Service.User;
import pl.woleszko.staz2017.task1.UserServiceDB.UserServiceDAO;
import pl.woleszko.staz2017.task1.userService.Service.UserService;

public class UserServiceImpl implements UserService{
	UserServiceDAO db;
	public UserServiceImpl(){
		db = new UserServiceDAO();
	}
	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		List<User> list = db.getTable();
		LinkedList<User> output = new LinkedList<User>();
		for(User user : list) {
			output.add(user);
		}
		return output;
	}

	public User getSingle(Long id) {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	
}
