package Package_person;

@SuppressWarnings("serial")
public class Liberian extends Person {
	
	private int lbin_id;
	private String  date_of_join;
	
	
	
	public int getLbin_id() {
		return lbin_id;
	}
	public void setLbin_id(int lbin_id) {
		this.lbin_id = lbin_id;
	}
	public String getDate_of_join() {
		return date_of_join;
	}
	public void setDate_of_join(String date_of_join) {
		this.date_of_join = date_of_join;
	}
	
	
	@Override
	public String toString() {
		return "Liberian [lbin_id=" + lbin_id + ", date_of_join=" + date_of_join + ", name=" + name + ", email_id="
				+ email_id + ", phone_number=" + phone_number + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	public Liberian(String name, String email_id, String phone_number, String address, String dob, int lbin_id,
			String date_of_join) {
		super(name, email_id, phone_number, address, dob);
		
		this.lbin_id = lbin_id;
		this.date_of_join = date_of_join;
	}
	
	public Liberian() {
		super();
	}
	
	

}
