package treeshopxml.Entities;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Seedlings {

	private String id;
	private String name;
	private String species;
	private int farm;
	private float price;
	private String metaName;
	private int viewCount;
	private float promtionPrice;
	private String img;
	private String moreImg;
	private String date;
	private String characteristic;
	private String care;
	private MultipartFile image;
	private MultipartFile [] moreImage;

	public Seedlings() {
		super();
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getFarm() {
		return farm;
	}

	public void setFarm(int farm) {
		this.farm = farm;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public MultipartFile[] getMoreImage() {
		return moreImage;
	}

	public void setMoreImage(MultipartFile[] moreImage) {
		this.moreImage = moreImage;
	}
	

}
