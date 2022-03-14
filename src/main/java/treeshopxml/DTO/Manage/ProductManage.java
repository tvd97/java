package treeshopxml.DTO.Manage;

import java.sql.Date;

public class ProductManage {
	private String id;
	private String name;
	private String species;
	private String metaname;
	private float price;
	private String views;
	private float promoPrice;
	private String img;
	private String moreImg;
	private Date date;
	private String charactic;
	private String care;

	public ProductManage() {
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

	public String getMetaname() {
		return metaname;
	}

	public void setMetaname(String metaname) {
		this.metaname = metaname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float prince) {
		this.price = prince;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public float getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(float promoPrice) {
		this.promoPrice = promoPrice;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCharactic() {
		return charactic;
	}

	public void setCharactic(String charactic) {
		this.charactic = charactic;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

}
