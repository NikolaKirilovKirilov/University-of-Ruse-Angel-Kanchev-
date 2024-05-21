package services;

import beans.User;
import beans.Database;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/{name}")
public class UserService {
	
	@EJB
	private Database database;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String GetUsers() {
		return database.getUsersAsJson();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String RegisterUser(User user) {
		database.RegisterUser(user);
		return user.ToJSON();
	}


	@GET
	@Path("/{name}") 
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsersByNameAndPassword(@PathParam("name") String name, @PathParam("password") String password) { 
		try
		{
			User user = database.checkUserPass(name, password);
			if (user != null) {
				return database.getUsersAsJson();
			} else {
				return "404"; 
			}
		}catch(Exception ex)
		{
			return "404";
		}
		
	}
}
