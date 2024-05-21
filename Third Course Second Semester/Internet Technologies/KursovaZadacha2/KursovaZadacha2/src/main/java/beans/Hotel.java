package beans;

import com.google.gson.Gson;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Hotel {
    @Id
    @GeneratedValue
    @JsonbProperty("id")
    private int id;

    @JsonbProperty("names")
    String names;
    
    @JsonbProperty("startDate")
    String startDate;
    
    @JsonbProperty("endDate")
    String endDate;
    
    @JsonbProperty("pricePerNight")
    double pricePerNight;
    
    @JsonbProperty("breakfast")
    Boolean breakfast;
    
    @JsonbProperty("dinner")
    Boolean dinner;
    
    @JsonbProperty("roomType")
    String roomType;

    public Hotel() {
    }

    @JsonbCreator
    public Hotel(@JsonbProperty("names") String names,
    		@JsonbProperty("startDate")String startDate,
    		@JsonbProperty("endDate")String endDate,
    		@JsonbProperty("pricePerNight") double pricePerNight,
    		@JsonbProperty("breakfast") Boolean breakfast,
    		@JsonbProperty("dinner") Boolean dinner,
    		@JsonbProperty("roomType") String roomType){
        this.names = names;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerNight = pricePerNight;
        this.breakfast = breakfast;
        this.dinner = dinner;
        this.roomType = roomType;
    }
    
    @JsonbCreator
    public Hotel(@JsonbProperty("id") int id,
    		@JsonbProperty("names") String names,
    		@JsonbProperty("startDate")String startDate,
    		@JsonbProperty("endDate")String endDate,
    		@JsonbProperty("pricePerNight") double pricePerNight,
    		@JsonbProperty("breakfast") Boolean breakfast,
    		@JsonbProperty("dinner") Boolean dinner,
    		@JsonbProperty("roomType") String roomType){
    	this.id = id;
    	this.names = names;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerNight = pricePerNight;
        this.breakfast = breakfast;
        this.dinner = dinner;
        this.roomType = roomType;
    }
    
	public String ToJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static Hotel FromJSON(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Hotel.class);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
    
}