package pl.woleszko.staz2017.task1.userService.Service;

import java.util.Random;

public class User {
	private Long id;
	private String name;
	private String login;
	
	public Long getIndex() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLogin() {
		return this.login;
	}	
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public void setLogin(String _login) {
		this.login = _login;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public User(String _name, String _login) {
		setIndex();
		this.name = _name;
		this.login = _login; 
	}
	
	private void setIndex() {
		Random generator = new Random();
		this.id = generator.nextLong();
	}
	

	

	
	
	
}
