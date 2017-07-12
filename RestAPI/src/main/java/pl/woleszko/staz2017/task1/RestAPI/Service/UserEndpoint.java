package pl.woleszko.staz2017.task1.RestAPI.Service;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.woleszko.staz2017.task1.userService.Service.*;

@Path("/users")
public class UserEndpoint {
	public UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserEndpoint(UserService _userService){
		this.userService = _userService;
	}
	
	public UserEndpoint() {
		
	}
		

	@GET
	@Path("/getuser/{id}")
	@Produces({"application/xml", "application/json"})
	public User getUser(@PathParam("id") Long id) {	
		
		User user = userService.getSingle(id);	
		return user;
	}
	

	@GET
	@Path("/getall")
	@Produces({"application/xml","application/json"})
	public LinkedList<User> getAll() {
		LinkedList<User> list = (LinkedList<User>) userService.getList();	

		
		User user1 = new User("login1","stefan",new Long(15));
		User user2 = new User("ksdf11", "fsd");				
		User user3 = new User("kewfdf11", "adsfadgk");		
		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		
		return list;
	}
	
	@POST
	@Path("/adduser")
	@Consumes({"application/xml","applicaton/json"})
	public Response addNew(User user) {
		
		System.out.println("Dodano " + user.getLogin() +" "+ user.getName());
		
		userService.addUser(user);

		return Response.ok().build();
	}
	
	@DELETE
	@Path("/deleteuser/{id}")
	public Response deleteUser(@PathParam("id") Long id) {
		
		System.out.println("Usunieto rekord");
		userService.deleteUser(id);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/edituser")
	@Consumes({"application/xml","applicaton/json"})
	public Response editUser(User user) {
		User user1 = userService.getSingle(user.getId());
		System.out.println("Zmieniono z: " + user1.getLogin() +" "+ user1.getName());
		
		userService.editUser(user);
		user = userService.getSingle(user.getId());
		

		System.out.print(" na: " + user.getLogin() +" "+ user.getName());
		return Response.ok().build();
	}
	


	
}
