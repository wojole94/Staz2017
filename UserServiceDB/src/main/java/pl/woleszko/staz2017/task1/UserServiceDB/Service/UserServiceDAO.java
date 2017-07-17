package pl.woleszko.staz2017.task1.UserServiceDB.Service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pl.woleszko.staz2017.task1.userService.Service.User;

public class UserServiceDAO {
	EntityManagerFactory factory;

	
	public UserServiceDAO(){
		getConnection();
	}
	
	public void getConnection() {
		factory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	}
	
	public void put(User user){
	      EntityManager entitymanager = factory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
		
	      entitymanager.persist( user );
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close();
	}
	public List<User> getTable() {
		// TODO Auto-generated method stub
		return null;
	
	}
	
	protected void finalize(){
		factory.close();
		
		
	}


	
}
