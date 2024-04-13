package Package_person;

@SuppressWarnings("serial")
public class Student extends Person {
	private int roll_no;
	private int std;
	private String division;
	
	public int getRoll_no() {
		return roll_no;
	}
	
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	public Student(String name, String email_id, String phone_number, String address, String dob, int roll_no, int std,
			String division) {
		super(name, email_id, phone_number, address, dob);
		this.roll_no = roll_no;
		this.std = std;
		this.division = division;
	}
	
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", std=" + std + ", division=" + division + ", name=" + name
				+ ", email_id=" + email_id + ", phone_number=" + phone_number + ", address=" + address + ", dob=" + dob
				+ "]";
	}

	public Student() {
		super();
	}
	
	

}
