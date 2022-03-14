package treeshopxml.Entities;

public class Species {
	private String id;
	private String name;
	private String metaName;

	public Species() {
		super();
	}

	public Species(String id, String name, String metaName) {
		super();
		this.id = id;
		this.name = name;
		this.metaName = metaName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

}


