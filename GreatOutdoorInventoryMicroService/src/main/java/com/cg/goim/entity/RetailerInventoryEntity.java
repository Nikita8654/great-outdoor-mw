package com.cg.goim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "great_outdoor_inventory_table")
public class RetailerInventoryEntity {
	
	@Id
	@Column(name = "inventory_id")
	private String inventoryId;
	
	@Column(name = "retailer_id", nullable = false)
	private String retailerId;
	
	@Column(name = "product_id", nullable = false)
	private String productId;
	
	@Column(name = "product_quantity", nullable = false)
	private int productQuantity;
	
	@Column(name = "total_amount", nullable = false)
	private double totalAmount;

	@Column(name = "product_receive_time", nullable = false)
	private long productReceiveTimeStamp; 
	
	@Column(name = "product_sale_time", nullable = false)
    private long productSaleTimeStamp; 

  
	
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}


	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
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
	
	

}
