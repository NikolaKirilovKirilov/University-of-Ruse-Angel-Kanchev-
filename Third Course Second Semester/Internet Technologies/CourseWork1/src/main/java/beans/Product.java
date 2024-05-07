package beans;

public class Product {
	private String code, name, weight, width, length, height, prodDate;
	
	public Product() {};
	public Product(String code, String name, String weight, String width, String length, String height, String prodDate) {
		this.code = code;
		this.name = name;
		this.weight = weight;
		this.width = width;
		this.length = length;
		this.height = height;
		this.prodDate = prodDate;
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
	public String getProdDate() {
		return prodDate;
	}
	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	};
}
