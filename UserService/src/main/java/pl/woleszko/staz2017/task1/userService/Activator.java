package pl.woleszko.staz2017.task1.userService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        // TODO add activation code here
    	System.out.println("UserService interface is aviable");
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	System.out.println("UserService interface is unaviable");
    }

}
