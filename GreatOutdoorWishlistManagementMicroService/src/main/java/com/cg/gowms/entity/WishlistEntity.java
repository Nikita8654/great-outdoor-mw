package com.cg.gowms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_wishlist_table")
public class WishlistEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wishlist_id")
	private long wishListId;
	
	@Column(name="user_id",nullable=false)
	private String userId;
	
	@Column(name="product_id",nullable=false)
	private String productId;
	
	public long getWishListId() {
		return wishListId;
	}
	public void setWishListId(long wishListId) {
		this.wishListId = wishListId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
