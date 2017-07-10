package pl.woleszko.staz2017.task1.userService.Service;

import java.util.Random;

public class User {
	private Long id;
	private String name;
	private String login;
	
	public User(String _name, String _login) {
		setIndex();
		this.name = _name;
		this.login = _login; 
	}
	
	private void setIndex() {
		Random generator = new Random();
		this.id = generator.nextLong();
	}
	
	public Long getIndex() {
		return this.id;
	}
	
}
