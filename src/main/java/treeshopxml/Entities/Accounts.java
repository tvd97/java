package treeshopxml.Entities;

public class Accounts {

	private String username;
	private String password;
	private String name;
	private int status;

	public Accounts() {
		super();
	}

	public Accounts(String username, String password,String name, int status) {
		super();
		this.username = username;
		this.password = password;
		this.name=name;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
