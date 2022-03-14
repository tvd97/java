package treeshopxml.Entities;

public class detailCarts {

	private int id;

	private int cart;

	private String seedling;

	private int count;
	private int status;

	public detailCarts() {
		super();
	}

	public detailCarts(int id, int cart, String seedling, int count, int status) {
		super();
		this.id = id;
		this.cart = cart;
		this.seedling = seedling;
		this.count = count;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
