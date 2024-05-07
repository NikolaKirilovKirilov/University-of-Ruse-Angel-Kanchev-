package beans;

public class Book {
	private String bookTitle, author, ganre, pageCount, coverPath, description;

	public Book() {};
	public Book(String bookTitle, String author, String ganre, String pageCount, String coverPath, String description)
	{
		this.bookTitle = bookTitle;
		this.author = author;
		this.ganre = ganre;
		this.pageCount = pageCount;
		this.coverPath = coverPath;
		this.description = description;
	};
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGanre() {
		return ganre;
	}

	public void setGanre(String ganre) {
		this.ganre = ganre;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
