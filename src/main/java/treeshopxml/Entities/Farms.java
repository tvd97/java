package treeshopxml.Entities;

public class Farms {
	private int id;
	private String name;
	private String phone;
	private String address;
	private String logo;
	private String idUser;
	private String metaName;

	public Farms() {
		super();
	}

	public Farms(int id, String name, String phone, String address, String logo, String idUser, String metaName) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.idUser = idUser;
		this.metaName = metaName;
		this.logo = logo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
