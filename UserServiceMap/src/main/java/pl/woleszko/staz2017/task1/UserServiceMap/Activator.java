package pl.woleszko.staz2017.task1.UserServiceMap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import pl.woleszko.staz2017.task1.UserServiceMap.Service.*;
import pl.woleszko.staz2017.task1.userService.Service.UserService;

public class Activator implements BundleActivator {
	ServiceRegistration userServiceRegistration;
    
	public void start(BundleContext context) throws Exception {
        // TODO add activation code here

		System.out.println("UserServices HashMap implementation is avaiable");
		
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here

		System.out.println("UserServices HashMap implementation is unavaiable");
    }

}
