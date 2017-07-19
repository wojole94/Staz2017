package pl.woleszko.staz2017.task1.userService.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface UserService {
	public User addUser(User user);
	public User editUser(User user);
	public Boolean deleteUser(Long idx);
	public User getSingle(Long idx);
	public LinkedList<User> getList();
}
