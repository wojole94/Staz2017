package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pl.woleszko.staz2017.task1.userService.Service.User;


public class UserServiceDAO {
	@PersistenceContext(unitName = "JPA")
	EntityManager em;
	
	public UserServiceDAO(){
	}
	

	@Transactional
	public void put(User user){
		  System.out.println("adding " +user.getId()+" "+ user.getName() + " "+ user.getLogin());
		  System.out.println("by " + em.toString());
		 
	      em.persist( user );
	      em.flush();
	      
	      System.out.println("end");
	}
	public List<User> getTable() {
		// TODO Auto-generated method stub
		return null;
	
	}
	


	
}
