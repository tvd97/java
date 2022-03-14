package treeshopxml.Entities;

public class Feedbacks {
	private int id;
	private int idFarm;
	private String img;
	private String content;
	private String moreImg;

	public Feedbacks() {
		super();
	}

	public Feedbacks(int id, int idFarm, String img, String content, String moreImg) {
		super();
		this.id = id;
		this.idFarm = idFarm;
		this.img = img;
		this.content = content;
		this.moreImg = moreImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMoreImg() {
		return moreImg;
	}

	public void setMoreImg(String moreImg) {
		this.moreImg = moreImg;
	}

}


