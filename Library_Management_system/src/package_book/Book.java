package package_book;

public class Book {
	private int isbn;
	private String tile;
	private String author;
	private String publisher;
	private int edition;
	private String subject;
	private int available_quantity;
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTile() {
		return tile;
	}
	
	public void setTile(String tile) {
		this.tile = tile;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getAvailable_quantity() {
		return available_quantity;
	}
	
	

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}
	
	public Book(int isbn, String tile, String author, String publisher, int edition, String subject,
			int available_quantity) 
	{
		super();
		this.isbn = isbn;
		this.tile = tile;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantity;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", tile=" + tile + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", subject=" + subject + ", available_quantity=" + available_quantity + "]";
	}
	
	
	

}
