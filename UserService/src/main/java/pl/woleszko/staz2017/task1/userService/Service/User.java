package pl.woleszko.staz2017.task1.userService.Service;

import javax.persistence.*;

import java.io.Serializable;
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
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_gen")
	@SequenceGenerator(name="seq_gen", sequenceName="id_seq_gen", allocationSize=1)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "login")
	private String login;
	
	public User() {
	}
	

	public User(Long id, String name, String login) {
		this.id = id;
		this.name = name;
		this.login = login; 
	}
	
	public User(String name, String login) {
		this.id = null;
		this.name = name;
		this.login = login;
	}
	@XmlAttribute
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
