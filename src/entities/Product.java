package entities;

public class Product {

	private String productName;
	private Double productPrice;
	private Integer productQuantity;
	
	public Product(String productName, Double productPrice, Integer productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public Double getProductPrice() {
		return productPrice;
	}
	
	public Integer getProductQuantity() {
		return productQuantity;
	}
	
	public Double total() {
		return productPrice * productQuantity;
	}
	
}
