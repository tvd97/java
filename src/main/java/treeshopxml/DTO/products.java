package treeshopxml.DTO;

import java.sql.Date;

public class products {
	private String id;
	private String name;
	private String nameSpecies;
	private String nameFarm;
	private float price;
	private String metaName;
	private int viewCount;
	private float promtionPrice;
	private String img;
	private String moreImg;
	private String care;
	private Date dateCreate;
	private String characteristic;
	private double rate;

	public products() {
		super();
	}

	public products(String id, String name, String nameSpecies, String nameFarm, float price, String metaName,
			int viewCount, float promtionPrice, String img, String moreImg, Date dateCreate, String characteristic,String care,double rate) {
		super();
		this.id = id;
		this.name = name;
		this.nameSpecies = nameSpecies;
		this.nameFarm = nameFarm;
		this.price = price;
		this.metaName = metaName;
		this.viewCount = viewCount;
		this.promtionPrice = promtionPrice;
		this.img = img;
		this.moreImg = moreImg;
		this.dateCreate = dateCreate;
		this.characteristic = characteristic;
		this.care=care;
		this.rate=rate;
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

	public String getNameSpecies() {
		return nameSpecies;
	}

	public void setNameSpecies(String nameSpecies) {
		this.nameSpecies = nameSpecies;
	}

	public String getNameFarm() {
		return nameFarm;
	}

	public void setNameFarm(String nameFarm) {
		this.nameFarm = nameFarm;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public float getPromtionPrice() {
		return promtionPrice;
	}

	public void setPromtionPrice(float promtionPrice) {
		this.promtionPrice = promtionPrice;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMoreImg() {
		return moreImg;
	}

	public void setMoreImg(String moreImg) {
		this.moreImg = moreImg;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	

}
