package Package_person;

import java.io.Serializable;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
abstract public class Person implements Serializable {
	protected String name;
	protected String email_id;
	protected String phone_number;
	protected String address;
	protected String dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		boolean isValidName = Pattern.matches("[a-z A-Z]+", name);
		if(isValidName)
			this.name = name;
		else
			this.name = "default Name";
	
	}
	public String getEmail_id() {
		return email_id;
	}
	
	
	public void setEmail_id(String email_id) {
		boolean isValidemail = Pattern.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", email_id);
		if(isValidemail)
			this.email_id = email_id;
		else
			this.email_id ="Inavlid Email";
	}
	
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		
		boolean isValidphone = Pattern.matches("[0-9]{10}",name);
		if(isValidphone)
			this.phone_number = email_id;
		else
			this.phone_number ="Inavlid Phone number";
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		boolean isValidDob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
		if(isValidDob)
			this.dob = dob;
		else
			this.dob = "01-06-2000";
	}
	public Person(String name, String email_id, String phone_number, String address, String dob) {
		super();
		this.setName(name);
		this.setEmail_id(email_id);
		this.setPhone_number(phone_number);
		this.address = address;
		this.setDob(dob); 
	}
	public Person() {
		super();
	}
	
	

}
