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

	public UserEndpoint(UserService userService){

		this.userService = userService;
	}
	
	public UserEndpoint() {
		
	}
		

	@GET
	@Path("/{id}")
	@Produces({"application/xml", "application/json"})
	public User getUser(@PathParam("id") Long id) {	
		
		User user = userService.getSingle(id);	
		return user;
	}
	

	@GET
	@Path("/")
	@Produces({"application/xml","application/json"})
	public LinkedList<User> getAll() {
		LinkedList<User> list =  userService.getList();	
		return list;
		
	}
	
	@POST
	@Path("/")
	@Consumes({"application/xml","applicaton/json"})
	public Response addNew(User user) {
		
		System.out.println("Dodano " + user.getLogin() +" "+ user.getName());
		
		userService.addUser(user);

		return Response.ok(user).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Long id) {
		
		System.out.println("Usunieto rekord" + id);
		userService.deleteUser(id);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/")
	@Consumes({"application/xml","applicaton/json"})
	@Produces({"application/xml","applicaton/json"})
	public User editUser(User user) {

		return userService.editUser(user);
	}
	


	
}
