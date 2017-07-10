package pl.woleszko.staz2017.task1.userService.Service;

import java.util.ArrayList;

public interface UserService {
	public Boolean addUser(User user);
	public Boolean editUser(User user);
	public Boolean deleteUser(Long idx);
	public User getSingle(Long idx);
	public ArrayList<User> getList();
}
