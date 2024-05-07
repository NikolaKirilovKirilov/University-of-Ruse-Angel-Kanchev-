package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;

@Named("Books")
@RequestScoped
public class Books {
	private static ArrayList<Book> books;

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static void setBooks(ArrayList<Book> books) {
		books.add(new Book());
	}
	
	public void initBooks()
	{
		books.add(new Book("A Million To One","Unknown","Novel","252","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\A-Milion-To-One-Front-Cover.jpg","No Description"));
		books.add(new Book("City of Orange","Unknown","Novel","132","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\City-Of-Orange-Front-Cover.jpg","No Description"));
		books.add(new Book("Soul","Unknown","Novel","197","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\Soul-Front-Cover.jpg","No Description"));
	}
}
