package beans;

import com.google.gson.Gson;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
    @GeneratedValue
    @JsonbProperty("name")
	private String name;
	
	@JsonbProperty("email")
	String email;

	@JsonbProperty("password")
	String password;
	
	public User() {}
	
	@JsonbCreator
	public User(@JsonbProperty("name") String name,
				@JsonbProperty("email") String email,
				@JsonbProperty("password") String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String ToJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static User FromJSON(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, User.class);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
