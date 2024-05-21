package beans;

import com.google.gson.Gson;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
    @GeneratedValue
    @JsonbProperty("code")
    private String code;

    @JsonbProperty("name")
    String name;
    
    @JsonbProperty("weight")
    String weight;
    
    @JsonbProperty("width")
    String width;
    
    @JsonbProperty("length")
    String length;
    
    @JsonbProperty("height")
    String height;
    
    @JsonbProperty("productionDate")
    String productionDate;

    public Product() {
    }

    @JsonbCreator
    public Product(@JsonbProperty("code") String code,
    			   @JsonbProperty("name")String name,
    			   @JsonbProperty("weight")String weight,
    			   @JsonbProperty("width") String width,
    			   @JsonbProperty("length") String length,
    			   @JsonbProperty("height") String height,
    			   @JsonbProperty("productionDate") String productionDate){
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        this.productionDate = productionDate;
    }
    
    @JsonbCreator
    public Product(@JsonbProperty("name") String name,
    			   @JsonbProperty("weight") String weight,
    			   @JsonbProperty("width") String width,
    			   @JsonbProperty("length") String length,
    			   @JsonbProperty("height") String height,
    			   @JsonbProperty("productionDate") String productionDate){
        this.name = name;
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        this.productionDate = productionDate;
    }
    
	public String ToJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static Product FromJSON(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Product.class);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
}
