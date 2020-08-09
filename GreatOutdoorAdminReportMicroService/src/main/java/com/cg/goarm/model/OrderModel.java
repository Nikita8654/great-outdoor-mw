package com.cg.goarm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class OrderModel {

	private String orderId;
	private String userId;
	private String addressId;
	private String productId;
    private double price;	 
	private String paymentType;
    private long itemQuantity;
	private int dispatchStatus;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate orderInitiateTime; 
	 @DateTimeFormat(iso = ISO.DATE)
	private LocalDate orderDispatchTime;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public long getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getDispatchStatus() {
		return dispatchStatus;
	}
	public void setDispatchStatus(int dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}
	public LocalDate getOrderInitiateTime() {
		return orderInitiateTime;
	}
	public void setOrderInitiateTime(LocalDate orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}
	public LocalDate getOrderDispatchTime() {
		return orderDispatchTime;
	}
	public void setOrderDispatchTime(LocalDate orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}
	 
	 
}
