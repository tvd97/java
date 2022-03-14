package treeshopxml.Entities;


public class Infomations {

	private String id;
	private String fistName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String username;

	public Infomations() {
		super();
	}

	public Infomations(String id, String fistName, String lastName, String address, String phone, String email,
			String username) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}


