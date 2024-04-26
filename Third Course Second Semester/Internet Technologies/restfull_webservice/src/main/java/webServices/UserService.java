package webServices;

import java.util.ArrayList;

import beans.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("users")
public class UserService
{
	static private ArrayList<User> users;
	
	public UserService()
	{
				if(users == null) {
							users = new ArrayList<User>();
							users.add(new User(1, "Борис Иванов", 10, "Русе, ул. Плиска 10"));
							users.add(new User(2, "Калоян Петров", 20, "Варна, ул. Александровска 20"));
							users.add(new User(3, "Вяра Стефанова", 30, "Бургас, ул. Стара планина 30"));
				}
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUsers() {
    			return users;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getUserById(@PathParam("id") int id) {
    		for (User user : users) {
    					if(user.getId() == id) return user;
			}
    		
    		ResponseBuilder rb = Response.status(404); 
    		return rb.build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
      			for (User user : users)  {
      						if(user.getId() == id) {
       								users.remove(user);    			
       								break;
      						}
    			}
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User newUser) {
        	int lastUserIndex = users.size()-1;    	
        	int nextAvailableID = users.get(lastUserIndex).getId() + 1; 	
        	newUser.setId(nextAvailableID);
    	    users.add(newUser);
        	return newUser;
    }
    
    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addUser(@PathParam("id") int id, User newUserData)
    {
        	for (int i=0 ; i<users.size() ; i++) 
        	{
    					User user = users.get(i);
    	
    					if(user.getId() == id)
    					{
    							newUserData.setId(id);
    							users.set(i,newUserData);
    			    		return newUserData;
    					}
        	}
        	ResponseBuilder rb = Response.status(404); 
    			return rb.build();  	
    }


}
