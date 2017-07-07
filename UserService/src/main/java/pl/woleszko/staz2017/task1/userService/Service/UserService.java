package pl.woleszko.staz2017.task1.userService.Service;

import java.util.ArrayList;

public interface UserService {
	public void addUser(User user);
	public void editUser(Long id);
	public void deleteUser(Long id);
	public User showSingle(Long id);
	public ArrayList<User> showList();
}
