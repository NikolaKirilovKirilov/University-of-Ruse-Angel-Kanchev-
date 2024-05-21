package beans;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("hotelBean")
@RequestScoped
public class HotelBean {
	private String names;
	private String startDate;
	private String endDate;
	private double pricePerNight;
	private Boolean breakfast;
	private Boolean dinner;
	private String roomType;

	@EJB
	private Database database;
	
	public String addReservation() {
		Hotel hotels = new Hotel(names, startDate, endDate, pricePerNight, breakfast, dinner, roomType);
		database.AddReservation(hotels);
		return "Reservation Added";
	}

	public void resetForm() {
	    this.names = "";
	    this.startDate = "";
	    this.endDate = "";
	    this.pricePerNight = 0;
	    this.breakfast = false;
	    this.dinner = false;
	    this.roomType = "";

	}
	
	public List<Hotel> getReservations() {
        return database.getAllReservations();
    }

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Boolean getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}

	public Boolean getDinner() {
		return dinner;
	}

	public void setDinner(Boolean dinner) {
		this.dinner = dinner;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
	

}