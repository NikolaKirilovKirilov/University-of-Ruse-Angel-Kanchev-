package beans;

import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("productBean")
@RequestScoped
public class ProductBean {

    String name;
    String weight;
    String width;
    String length;
    String height;
    String productionDate;

	@EJB
	private Database database;
	
	public String addProduct() {
		Product products = new Product(name, weight, width, length, height, productionDate);
		database.AddProduct(products);
		return "Reservation Added";
	}
	
	public void resetForm() {
	    this.name = "";
	    this.weight = "";
	    this.width = "";
	    this.length = "";
	    this.height = "";
	    this.productionDate = "";

	}
	
	public List<Product> getProducts() {
		return database.getAllProducts();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
}
