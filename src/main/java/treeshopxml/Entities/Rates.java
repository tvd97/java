package treeshopxml.Entities;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Rates {
	private int id;
	private String idSeedling;
	private float rate;
	private String date;
	private String content;
	private String name;

	public Rates() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdSeedling() {
		return idSeedling;
	}

	public void setIdSeedling(String idSeedling) {
		this.idSeedling = idSeedling;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
