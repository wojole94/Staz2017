package pl.woleszko.staz2017.task1.UserServiceMap.DatabaseAccess;

import java.util.HashMap;

import pl.woleszko.staz2017.task1.userService.Service.User;

public class DatabaseAccessObject {
	private HashMap db = new HashMap();
	
	public User getRecordFrom(Long idx) {
		return (User) db.get(idx);
	}
	
	public void setRecordAt(Long idx) {
		
	}
}
