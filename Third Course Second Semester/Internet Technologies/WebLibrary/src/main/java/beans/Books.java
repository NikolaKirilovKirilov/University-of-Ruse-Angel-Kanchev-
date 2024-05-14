package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;

@Named("books")
@RequestScoped
public class Books {
	private static ArrayList<Book> bookList;

	public static ArrayList<Book> getBooks() {
		return bookList;
	}

	public void setBooks(ArrayList<Book> books) {
		this.bookList = books;
	}
	
	public void initBooks()
	{
		bookList.add(new Book("A Million To One","Unknown","Novel","252","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\A-Milion-To-One-Front-Cover.jpg","No Description"));
		bookList.add(new Book("City of Orange","Unknown","Novel","132","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\City-Of-Orange-Front-Cover.jpg","No Description"));
		bookList.add(new Book("Soul","Unknown","Novel","197","D:\\GitHub Repos\\University-of-Ruse-Angel-Kanchev-\\Third Course Second Semester\\Internet Technologies\\WebLibrary\\src\\main\\webapp\\resources\\Soul-Front-Cover.jpg","No Description"));
	}
}
