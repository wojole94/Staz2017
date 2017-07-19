package pl.woleszko.staz2017.task1.RestAPI;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import pl.woleszko.staz2017.task1.RestAPI.Service.UserEndpoint;
import pl.woleszko.staz2017.task1.userService.Service.*;


public class Activator implements BundleActivator {
	ServiceReference userServiceReference;
	ServiceRegistration restAPIServiceReference;
	
    public void start(BundleContext context) throws Exception {
        // TODO add activation code here

    	System.out.println("RestAPI Service is avaiable");
    	
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	
    	System.out.println("RestAPI Service is unavaiable");
    }
    
    public void onBindService(final UserService userService) {
    	if (userService == null) System.out.println("userService is null");
    	else System.out.println("service should work properly");
    }
    
    public void onUnbindService(final UserService userService) {
    	System.out.println("service unbound");

    }
    
    

}
