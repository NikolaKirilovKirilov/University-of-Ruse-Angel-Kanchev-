package Services;

import beans.Hotel;
import beans.Database;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("reservations")
public class HotelService {

	@EJB
	private Database database;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String GetReservations() {
		return database.getReservationAsJson();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddReservation(Hotel reservations) {
		database.AddReservation(reservations);
		return reservations.ToJSON();
	}


	@GET
	@Path("/{name}") 
	@Produces(MediaType.APPLICATION_JSON)
	public String getReservationByName(@PathParam("name") String names) { 
		try
		{
			Hotel reservations = database.getReservations(names);
			if (reservations != null) {
				return reservations.ToJSON();
			} else {
				return "404"; 
			}
		}catch(Exception ex)
		{
			return "404";
		}
		
	}

}
