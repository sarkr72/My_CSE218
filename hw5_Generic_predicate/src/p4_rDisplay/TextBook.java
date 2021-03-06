package p4_rDisplay;

public class TextBook extends Person {

	private String titles;
	private String isbn;
	private Author author;
	private double price;

	public TextBook(String titles, String isbn, Author author, double price) {
		super(author.getName());
		this.titles = titles;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [" + super.toString() + "titles=" + titles + ", isbn=" + isbn + " " + "author = " + author + ", price=" + price
				+ "] \n";
	}
}
