package pl.woleszko.staz2017.task1.UserServiceDB;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;



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