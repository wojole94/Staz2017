package pl.woleszko.staz2017.task1.UserServiceAdmin;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.*;
import pl.woleszko.staz2017.task1.userService.Service.UserService;
import pl.woleszko.staz2017.task1.UserServiceDB.Service.*;
import pl.woleszko.staz2017.task1.UserServiceMap.Service.*;


public class Activator implements BundleActivator, ManagedService {
	static String CONFIG_PID = "USConfigAdmin";
	Boolean dbMode = false;
	Boolean mapMode = true;
	BundleContext context;

	

	ServiceRegistration userServiceMapRegistration;
	ServiceRegistration userServiceDBRegistration;
	ServiceRegistration configRegistration;
	ServiceReference daoRef;


	
    public void start(BundleContext context) throws Exception {
        // TODO add activation code here
    	this.context = context;
    	
    	Hashtable <String, Object> properties = new Hashtable<String, Object>();
        properties.put(Constants.SERVICE_PID, CONFIG_PID);
        properties.put("db", "false");
        properties.put("map", "true");
        
        configRegistration = context.registerService (ManagedService.class.getName(),
         this , properties);
        
		UserServiceMapImpl userServiceMap = new UserServiceMapImpl();
        userServiceMapRegistration = context.registerService (UserService.class.getName(),
                userServiceMap , null);
        
        
    	System.out.println("Implementation config avaiable");
		System.out.println("Map implementation");
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	if(!userServiceDBRegistration.equals(null)) userServiceDBRegistration.unregister();
    	if(!userServiceMapRegistration.equals(null)) userServiceMapRegistration.unregister();
    	configRegistration.unregister();

    	System.out.println("Implementation config unavaiable");
    }
    
    public void updated (Dictionary config) {

    		String db = (String)config.get("db");
    		String map = (String)config.get("map");
    		
    		if(db.equals("true")) dbMode = true;
    		else dbMode = false;
    		if(map.equals("true")) mapMode = true;    		
    		else mapMode = false;
    		
    		if (dbMode) {
    	    	userServiceMapRegistration.unregister();
    			System.out.println("DB implementation");
    	        daoRef = context.getServiceReference(ServiceDAO.class.getName());
    	        ServiceDAO dao = (ServiceDAO) context.getService(daoRef);
    	        UserServiceDBImpl userServiceDB = new UserServiceDBImpl(dao);
    	        userServiceDBRegistration = context.registerService (UserService.class.getName(),
    	                userServiceDB , null);
    			//Wystawiam db
    		}    		
    		if (mapMode) {
    	    	userServiceDBRegistration.unregister();
    			System.out.println("Map implementation");
    			UserServiceMapImpl userServiceMap = new UserServiceMapImpl();
    	        userServiceMapRegistration = context.registerService (UserService.class.getName(),
    	                userServiceMap , null);
    			//Wystawiam mape
    		}
    		
    		
    	}


}
