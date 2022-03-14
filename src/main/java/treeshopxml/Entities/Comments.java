package treeshopxml.Entities;

import org.springframework.stereotype.Repository;

@Repository
public class Comments {
	
	private int id;
	
	private String seedling;
	
	private String name;
	
	private String content;

	public Comments() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeedling() {
		return seedling;
	}

	public void setSeedling(String seedling) {
		this.seedling = seedling;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
