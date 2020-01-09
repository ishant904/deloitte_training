package test1;

public class Book {
	private int isbn;
	private String title;
	private int pages;
	private int pubYear;
	private String type;
	private Author auth;
	public Book(int isbn, String title, int pages, int pubYear, String type,Author auth) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.pubYear = pubYear;
		this.type = type;
		this.auth=auth;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPubYear() {
		return pubYear;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", pubYear=" + pubYear + ", type="
				+ type + "]";
	}
	
}
