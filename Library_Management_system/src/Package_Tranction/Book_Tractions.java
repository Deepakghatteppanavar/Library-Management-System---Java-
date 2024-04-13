package Package_Tranction;

public class Book_Tractions {
	private  int isbn;
	private int rollno;
	private String issueDate;
	private String returnDate;
	
	
	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public int getRollno() {
		return rollno;
	}


	public void setRollno(int rollno) {
		this.rollno = rollno;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	public Book_Tractions(int isbn, int rollno, String issueDate, String returnDate) {
		super();
		this.isbn = isbn;
		this.rollno = rollno;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}


	public Book_Tractions() {
		super();
	}


	@Override
	public String toString() {
		return "Book_Tractions [isbn=" + isbn + ", rollno=" + rollno + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + "]";
	}
	
	
	

}
