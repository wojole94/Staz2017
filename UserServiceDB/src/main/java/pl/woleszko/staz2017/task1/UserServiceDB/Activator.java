package pl.woleszko.staz2017.task1.UserServiceDB;


import org.hibernate.jpa.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import javax.persistence.spi.PersistenceProvider;
import java.util.Dictionary;
import java.util.Hashtable;

import pl.woleszko.staz2017.task1.UserServiceDB.Service.UserServiceImpl;
import pl.woleszko.staz2017.task1.userService.Service.UserService;

public class Activator implements BundleActivator {
//	ServiceRegistration userServiceRegistration;


    
	public void start(BundleContext context) throws Exception {
        // TODO add activation code here
    		
    	
//		UserService userService = new UserServiceImpl();
//		userServiceRegistration = context.registerService(UserService.class.getName(), userService, null);
		
		System.out.println("UserServices Database implementation is avaiable");
		
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
//    	userServiceRegistration.unregister();

		System.out.println("UserServices Database implementation is unavaiable");
    }
}