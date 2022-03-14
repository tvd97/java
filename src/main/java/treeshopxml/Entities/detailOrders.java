package treeshopxml.Entities;

public class detailOrders {

	private int id;
	private int order;
	private String seedling;
	private int count;
	private float totalPrice;

	public detailOrders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getSeedling() {
		return seedling;
	}

	public void setSeedling(String seedling) {
		this.seedling = seedling;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
