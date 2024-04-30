package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;

@Named("books")
@RequestScoped
public class Books {
	private static ArrayList<Book> books;

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static void setBooks(ArrayList<Book> books) {
		Books.books = books;
	}
	
	public void initBooks()
	{
		
	}
}
