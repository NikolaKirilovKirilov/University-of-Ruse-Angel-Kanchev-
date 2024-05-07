package beans;
import java.util.ArrayList;

public class Database {
	static private ArrayList<Product> inventory;
	
	public Database()
	{
		inventory = new ArrayList<Product>();
		inventory.add(new Product("1","Wood Plank","12.30","20","15.4","2.5","05.07.2024"));
		inventory.add(new Product("2","Metal Bar","45.02","5","50.5","5","04.07.2024"));
		inventory.add(new Product("3","Glass Pane","23.45","45","2.3","60","02.07.2024"));
	}

	public ArrayList<Product> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Product> inventory) {
		Database.inventory = inventory;
	}
	
	public void addProduct(Product p)
	{
		inventory.add(p);
	}
}
