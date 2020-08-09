package com.cg.goim.model;


public class RetailerInventoryModel {
	
	private String inventoryId;
	private String retailerId;
	private String productCategory;
	private String productId;
	private String productName;
	private String productColor;
	private String productSpecification;
	private int productQuantity;
	private double totalAmount;
	private long productReceiveTimeStamp;
	private long productSaleTimeStamp; 
	 private double productActualPrice;
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public long getProductReceiveTimeStamp() {
		return productReceiveTimeStamp;
	}
	public void setProductReceiveTimeStamp(long productReceiveTimeStamp) {
		this.productReceiveTimeStamp = productReceiveTimeStamp;
	}
	public long getProductSaleTimeStamp() {
		return productSaleTimeStamp;
	}
	public void setProductSaleTimeStamp(long productSaleTimeStamp) {
		this.productSaleTimeStamp = productSaleTimeStamp;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}
	
	public double getProductActualPrice() {
		return productActualPrice;
	}
	public void setProductActualPrice(double productActualPrice) {
		this.productActualPrice = productActualPrice;
	}
	
	

	
}
