package vn.oitstar.model;

public class ProductModel {
	private int id;
	private String name;
	private String description;
	private double price;
	private String image;
	private int categoryID;
	private int sellerID;
	private int amount;
	public ProductModel() {
		super();
	}
	public ProductModel(int id, String name, String description, double price, String image, int categoryID,
			int sellerID, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", categoryID=" + categoryID + ", sellerID=" + sellerID + ", amount=" + amount
				+ "]";
	}
	

	
}
