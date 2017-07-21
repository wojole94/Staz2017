package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.woleszko.staz2017.task1.userService.Service.User;


public class UserServiceDAO implements ServiceDAO {
	@PersistenceContext(unitName = "JPA")
	EntityManager em;
	
	public UserServiceDAO(){
	}
	

	@Transactional
	public User put(User user){

	      em.persist( user );
	      return em.find(User.class, user.getId());
	      
	      
	}
	
	@Transactional
	public User get(Long id) {
		
		User user = em.find(User.class, id);
		
		return user;
	}
	
	@Transactional
	public ArrayList<User> getTable() {
		// TODO Auto-generated method stub
	    
		Query query = em.createQuery("Select u from User u ORDER BY u.id ASC");
		return (ArrayList<User>) query.getResultList();
	
	}
	
	@Transactional
	public User edit(User newone) {
		
		User edited = em.find(User.class, newone.getId());
		if (edited.equals(null)) return null;
		edited.setLogin(newone.getLogin());
		edited.setName(newone.getName());
		em.persist(edited);
		
		return edited;
	}
	
	@Transactional
	public Boolean delete(Long id) {
	
	    User user = em.find(User.class, id );
	    
		if(user.equals(null)) return false;    
	    em.remove(user);
		
	    return true;

	}
	


	
}
