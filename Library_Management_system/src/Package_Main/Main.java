package Package_Main;

import java.util.Scanner;

import Package_Exception.BookNotFoundException;
import Package_Exception.StudentNotFoundException;
import Package_Tranction.Book_Traction_Manager;
import Package_person.Student;
import Package_person.StudentManager;
import package_book.Book;
import package_book.Book_Manager;

public class Main {
	public static void main(String args[]) {
		int choice = 0;
		
		Scanner sc =  new Scanner(System.in);
		
		Book_Manager bm = new Book_Manager();
		StudentManager sm = new StudentManager();
		Book_Traction_Manager btm = new Book_Traction_Manager();
		
		do {
			System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to Exit:");
			choice = sc.nextInt();
			
			if (choice == 1) // if user is Student
			{
				System.out.println("Enter Your Roll Number");
				int rollNo = sc.nextInt();
				try {
					Student s = sm.get(rollNo);
					if (s == null)
						throw new StudentNotFoundException();
					int stud_choice;
					
					do {
						System.out.println("Enter 1 to View All Books\nEnter 2 to Search Book by ISBN\nEnter 3 to List Books By Subject\nEnter 4 to Issue a Book\nEnter 5 to Return a Book\nEnter 99 to Exit");
						stud_choice = sc.nextInt();
						switch(stud_choice){
						case 1:
							System.out.println("All the Book Records are");
							bm.booAllview();
							break;
							
						case 2:
							System.out.println("Please Enter ISBN To Search");

							int search_isbn = sc.nextInt();
							Book book = bm.searchBookByIsbn(search_isbn);
							if (book == null)
								System.out.println("No Book with this ISBN Exists in Our Library");
							else
								System.out.println(book);
							break;
							
						case 3:
							System.out.println("Enter the Subject to Search");
							sc.nextLine();
							
							String search_subject = sc.nextLine();
							bm.listBooksBySubject(search_subject);
							break;
							
						case 4:
							System.out.println("Enter the ISBN to Issue a Book");
							int issue_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(issue_isbn);
							try {
								if (book == null) {
									throw new BookNotFoundException();				
								}
								if (book.getAvailable_quantity() > 0)
								{
									if (btm.issueBook(rollNo, issue_isbn)) {
										book.setAvailable_quantity(book.getAvailable_quantity()-1);
										System.out.println("Book Has Been Issued");
									}
								}
								else {
									System.out.println("The Book has Been Issued...");
								}
								
							}
							catch(BookNotFoundException bnfe) {
								System.out.println(bnfe);
							}
							
							break;
							
							
						case 5:
							System.out.println("Please Enter the ISBN to Return a Book");
							int return_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							if (book != null) {
								if (btm.returnBook(rollNo, return_isbn)) {
									book.setAvailable_quantity(book.getAvailable_quantity()+1);
									System.out.println("Thank You for Returning the Book");
								}else
									System.out.println("Could Not Return the Book");
							}else
								System.out.println("Book with this ISBN Does not Exists");
							break;
							
							
						case 99:
							System.out.println("Thank You for Using Library");
							break;
						default:
							System.out.println("Invalid Choice");
						}
					}while(stud_choice != 99);
					
				}
				catch(StudentNotFoundException snfe) {
					System.out.println(snfe);
				}
				
			}
			else if (choice == 2) // user is a Librarian
			{
				int lib_choice;
				do {
					
					System.out.println("Enter 11 to View all Students\nEnter 12 to Print a Student by Roll Number\nEnter 13 to Register a Student\nEnter 14 to Update a Student\nEnter 15 to Delete a Student");
					System.out.println("Enter 21 to View all Books\nEnter 22 to Print a Book by ISBN\nEnter 23 to Add a  New Book\nEnter 24 to Update a Book\nEnter 25 to Delete a Book");
					System.out.println("Enter 31 to view all Transactions");
					System.out.println("Enter 99 to to Exit");
					lib_choice = sc.nextInt();
					switch(lib_choice) {
					case 11: // view all students 
						System.out.println("All the Students Records");
						sm.viewAllStudents();
						break;
						
					case 12: // search a student based on roll number
						System.out.println("Enter Roll Number to Fetch Student's Record");
						int get_rollNo = sc.nextInt();
						Student student = sm.get(get_rollNo);
						if (student == null) {
							System.out.println("No Record Matches this Roll Number");
						}
						else
							System.out.println(student);
						break;
						
					case 13:   // adding a student
						System.out.println("Enter Students Details to Add");
						String name;
						String emailId;
						String phoneNumber;
						String address;
						String dob;
						int rollNo;
						int std;
						String division;
						sc.nextLine();
						
						
						System.out.println("Name");
						name = sc.nextLine();
						
						System.out.println("EmailId");
						emailId = sc.nextLine();
						
						System.out.println("Phone Number");
						phoneNumber = sc.nextLine();
						
						System.out.println("Address");
						address = sc.nextLine();
						
						System.out.println("Date of Birth");
						dob = sc.nextLine();
						
						System.out.println("Roll Number as Integer");
						rollNo = sc.nextInt();
						
						System.out.println("Standard as Integer");
						std = sc.nextInt();
						
						System.out.println("Division");
						division = sc.nextLine();
						sc.nextLine();
						
						
						
						student = new Student(name, emailId, phoneNumber, address,  dob, rollNo,  std, division);
						sm.addAStudent(student);
						System.out.println("Student is Added");
						break;
					
					case 14: //update a student
						System.out.println("Enter The Roll Number to Modify the Record");
						int modify_rollNo;
						modify_rollNo = sc.nextInt();
						student = sm.get(modify_rollNo);
						
						try {
							if (student == null)
								throw new StudentNotFoundException();
							
							sc.nextLine();
							System.out.println("Name");
							name = sc.nextLine();
							
							System.out.println("EmailId");
							emailId = sc.nextLine();
							
							System.out.println("Phone Number");
							phoneNumber = sc.nextLine();
							
							System.out.println("Address");
							address = sc.nextLine();
							
							System.out.println("Date of Birth");
							dob = sc.nextLine();
							
							System.out.println("Standard as Integer");
							std = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Division");
							division = sc.nextLine();
							
							sm.updateStudent(modify_rollNo, name, emailId, phoneNumber, address, dob, std, division);
							System.out.println("Student Record is Update");
						}
						catch(StudentNotFoundException snfe) {
							System.out.println(snfe);
						}
						break;
						
						
						
					case 15:  //to delete student
						System.out.println("Enter The Roll Number to Delete the Record");
						int delete_rollNo;
						delete_rollNo = sc.nextInt();
						if (sm.deleteStudent(delete_rollNo))
							System.out.println("Student Record is Removed");
						else
							System.out.println("No Record with Given Roll Number Exists");
						break;
					
					case 21:
						System.out.println("View ALl Books");
						bm.booAllview();
						break;
						
					case 22: // search a book based on isbn number
						System.out.println("Enter Book Isbn to Fetch Book's Record");
						int search_isbn = sc.nextInt();
						Book bk = bm.searchBookByIsbn(search_isbn);
						if (bk == null) {
							System.out.println("No Record Matches this ISbn Number in our libary");
						}
						else
							System.out.println(bk);
						break;
						
					case 23://add a book to record
						System.out.println("Please Book details to add");
						 int isbn;
						 String tile;
						 String author;
						 String publisher;
						 int edition;
						 String subject;
						 int available_quantity;
						 
							sc.nextLine();

							System.out.println("Enter a isbn");
							isbn = sc.nextInt();
							
							System.out.println("Tile of the Book\n");
							tile = sc.nextLine();
							sc.nextLine();
							
							System.out.println("Author of the Book\n");
							author = sc.nextLine();
							
							System.out.println("Publisher of the Book");
							publisher = sc.nextLine();
							
							System.out.println("Edition of the Book");
							edition = sc.nextInt();
							
							System.out.println("Subject of the Book\n");
							subject = sc.nextLine();
							sc.nextLine();
							System.out.println("Available Quantity of the Book");
							available_quantity = sc.nextInt();
							
							sc.nextLine();
							
							bk = new Book( isbn , tile,  author,  publisher,  edition,  subject, available_quantity);
							bm.bookadd(bk);
							System.out.println( "Books are added successfully");
						break;
						
					case 24:
						System.out.println("Enter a Isbn to modify the book details");
						int modify_isbn;
						modify_isbn = sc.nextInt();
						
						try {
							bk =  bm.searchBookByIsbn(modify_isbn);
							
							if (bk == null) {
								throw new BookNotFoundException();
							}
							
								
								System.out.println("Tile of the Book\n");
								tile = sc.nextLine();
															
								System.out.println("Author of the Book");
								author = sc.nextLine();
								
								System.out.println("Publisher of the Book");
								publisher = sc.nextLine();
								
								System.out.println("Edition of the Book");
								edition = sc.nextInt();
								
								System.out.println("Subject of the Book\n");
								subject = sc.nextLine();
								
								System.out.println("Available Quantity of the Book");
								available_quantity = sc.nextInt();
								
								bm.updateBook( modify_isbn , tile,  author,  publisher,  edition,  subject, available_quantity);
								
						} catch (BookNotFoundException ewq) {
							System.out.println(ewq);
						}					
						break;
						
						
					case 25:
						System.out.println("Enter a Isbn to Remove a Book");
						int delete_isbn = sc.nextInt();
						try {
						Book bok = bm.searchBookByIsbn(delete_isbn);
						
						if (bok == null) 
							throw new BookNotFoundException();
						
						bm.deleteBook(delete_isbn);
						System.out.println("Book record deleted successfully");
						
						}catch (BookNotFoundException eer) {
							System.out.println(eer);
						}
						break;
						
					case 31: 
						System.out.println("All Tranctions are ");
						btm.showAll();
							
					
					case 99:
						System.out.println("Thank You for Using Library");
						break;
					default:
						System.out.println("Invalid Choice");
					
					}
				}while(lib_choice != 99);	
				
			}
			
			
		}while(choice != 3);
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
		
	}
	
}
