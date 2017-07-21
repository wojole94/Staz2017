package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.ArrayList;

import pl.woleszko.staz2017.task1.userService.Service.User;

public interface ServiceDAO {
	public User put(User user);
	public User get(Long id) ;
	public ArrayList<User> getTable();
	public User edit(User newone);
	public Boolean delete(Long id);
}
