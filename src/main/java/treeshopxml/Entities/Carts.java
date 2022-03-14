package treeshopxml.Entities;

public class Carts {

	private int id;
	
	private String user;

	public Carts() {
		super();
	}

	public Carts(int id, String user) {
		super();
		this.id = id;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
