package com.cg.goams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_address_table")
public class AddressEntity {

	@Id
	@Column(name="address_id")
	private String addressId;
	
	@Column(name="user_id",nullable=false)
	private String userId;
	
	@Column(name="fullname",nullable=false)
	private String fullName;
	
	@Column(name="address_line",nullable=false)
	private String addressLine;
	
	@Column(name="city",nullable=false)
	private String city;
	
	@Column(name="state",nullable=false)
	private String state;
	
	@Column(name="pincode",nullable=false)
	private long pincode;
	
	@Column(name="phone_no",nullable=false)
	private String phoneNo;
	
	@Column(name="other_phone_no")
	private String otherPhoneNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="address_type",nullable=false)
	private AddressType addressType;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getOtherPhoneNo() {
		return otherPhoneNo;
	}
	public void setOtherPhoneNo(String otherPhoneNo) {
		this.otherPhoneNo = otherPhoneNo;
	}
	
	
}
