package emtity;

public class Product {
	
	private String name;
	private int quantity;
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String _name, int _quantity, String _price) {
		this.name = _name ;
		this.quantity = _quantity;	
		this.price = _price;
	}

}
