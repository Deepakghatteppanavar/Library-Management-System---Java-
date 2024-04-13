package Package_Tranction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@SuppressWarnings("serial")
public class Book_Traction_Manager implements Serializable
{
	ObjectOutputStream oos_book_tranction = null;
	ObjectInputStream ois_book_tranction = null;
	
	File book_tractions_file = null;
	ArrayList<Book_Tractions> book_tractions_list=null;
	
	
	
	@SuppressWarnings("unchecked")
	public Book_Traction_Manager() {
		book_tractions_file = new File("Book_Tractions.bat");
		book_tractions_list = new ArrayList<Book_Tractions>();
		
		if(book_tractions_file.exists()) 
		{
			try {
				ois_book_tranction = new  ObjectInputStream(new FileInputStream(book_tractions_file));
				book_tractions_list = (ArrayList<Book_Tractions>) ois_book_tranction.readObject();			

			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	public boolean issueBook(int rollno, int isbn) {
		int total_book_issue = 0;
		
		for(Book_Tractions book_tranction:book_tractions_list) {
			if((book_tranction.getRollno() == rollno) && (book_tranction.getReturnDate())==null)
				total_book_issue +=1;
			if(total_book_issue >= 3)
				return false;
				
		}
		String issue_date = new SimpleDateFormat("dd-mm-yyy").format(new Date());
		Book_Tractions book_Tractions = new Book_Tractions(isbn,rollno,issue_date,null);
		book_tractions_list.add(book_Tractions);
		return false;
	}
	
	public boolean returnBook(int rollno, int isbn) {
		for(Book_Tractions book_tranction:book_tractions_list) {
			if((book_tranction.getRollno() == rollno)&&(book_tranction.getIsbn()==isbn) && (book_tranction.getReturnDate())==null) {
				
			
				String return_date = new SimpleDateFormat("dd-mm-yyy").format(new Date());
				book_tranction.setReturnDate(return_date);
				return true;

			}
			
		}
		return false;
		
	}
	public void showAll() {
		for(Book_Tractions book_tranction:book_tractions_list)
			System.out.println(book_tranction);
	}

	public void writeToFile() {
		// TODO Auto-generated method stub
		try {
			oos_book_tranction = new ObjectOutputStream(new FileOutputStream(book_tractions_file));
			oos_book_tranction.writeObject(book_tractions_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
