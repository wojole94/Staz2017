package pl.woleszko.staz2017.task1.UserServiceDB;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pl.woleszko.staz2017.task1.userService.Service.User;

public class UserServiceDAO {
	SessionFactory factory;
	Session session;
	
	public UserServiceDAO(){
		getConnection();
	}
	
	public void getConnection() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		Metadata metadata = new MetadataSources( standardRegistry )
				.addAnnotatedClass( User.class )
			    .getMetadataBuilder()
			    .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
			    .build();

		factory = metadata.getSessionFactoryBuilder()
			    .build();
	}
	
	public List<User> getTable(){


			session = factory.openSession();
			session.beginTransaction();
			List<User> result = session.createQuery( "from USERS" ).list();
			session.getTransaction().commit();
			session.close();

			return result;
	}
	
	
}
