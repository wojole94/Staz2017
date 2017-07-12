package pl.woleszko.staz2017.task1.RestAPI.Service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	
	private String formatXMLData(User user) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("<user>");
		buffer.append("<index>" + user.getIndex() + "</index>");
		buffer.append("<login>" + user.getLogin() + "</login>");
		buffer.append("<name>" + user.getName() + "</name>");
		buffer.append("</user>");
		
		return buffer.toString();
	}
	
	@Produces("application/xml")
	@GET
	@Path("/getuser/{id}")
	public Response getUser(@PathParam("id") Long id) {	
		
		User user = userService.getSingle(id);	
		return Response.ok(new String(formatXMLData(user))).build();
	}
	
	@Produces("application/xml")
	@GET
	@Path("/getall")
	public Response getAll() {
		ArrayList<User> list = userService.getList();	
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("<list>");
		for(User user : list) {
			buffer.append(formatXMLData(user));
		}
		buffer.append("</list>");		

		return Response.ok(new String(buffer.toString())).build();
	}
	
	
	
	
}
