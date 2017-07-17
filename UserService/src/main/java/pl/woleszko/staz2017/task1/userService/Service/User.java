package pl.woleszko.staz2017.task1.userService.Service;

import javax.persistence.*;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "USERS")
@XmlRootElement(name = "user")
public class User extends Object{
	
	@Id
	@Column
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private String login;
	
	public User() {
	}
	
	public User(String _name, String _login) {
		setIndex();
		this.name = _name;
		this.login = _login; 
	}

	public User(String _name, String _login, Long _index) {
		this.id = _index;
		this.name = _name;
		this.login = _login; 
	}
	
	@XmlElement
	public void setName(String _name) {
		this.name = _name;
	}
	public String getName() {
		return this.name;
	}
	@XmlElement
	public void setLogin(String _login) {
		this.login = _login;
	}

	public String getLogin() {
		return this.login;
	}	

	public Long getId() {
		return this.id;
	}
	@XmlElement
	public void setId(Long _index) {
		this.id = _index;
	}
	
	private void setIndex() {
		Random generator = new Random();
		this.id = generator.nextLong();
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


	

	

	

	
	
	
}
