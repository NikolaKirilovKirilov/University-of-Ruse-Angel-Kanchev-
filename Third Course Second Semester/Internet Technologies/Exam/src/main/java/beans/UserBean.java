package beans;

import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("userBean")
@RequestScoped
public class UserBean {
	
	String name;
    String email;
    String password;

	@EJB
	private Database database;
	
	public String addUser() {
		User users = new User(name, email, password);
		database.RegisterUser(users);
		return "User Added";
	}
	
	public void resetForm() {
	    this.name = "";
	    this.email = "";
	    this.password = "";
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

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
}
