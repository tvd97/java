package treeshopxml.Entities;


public class RoleUsers {
	private int id;
	private String idRole;
	private String idUser;

	public RoleUsers() {
		super();
	}

	public RoleUsers(int id, String idRole, String idUser) {
		super();
		this.id = id;
		this.idRole = idRole;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return idRole;
	}

	public void setRole(String idRole) {
		this.idRole = idRole;
	}

	public String getUser() {
		return idUser;
	}

	public void setUser(String idUser) {
		this.idUser = idUser;
	}

}


