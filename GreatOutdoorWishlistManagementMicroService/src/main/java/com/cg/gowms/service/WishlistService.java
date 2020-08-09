package com.cg.gowms.service;

import java.util.List;

import com.cg.gowms.exception.WishlistException;
import com.cg.gowms.model.WishlistModel;

public interface WishlistService {
	public List<WishlistModel> findAll(String userId);
	
	public WishlistModel findByIdAndUserId(String productId,String userId);
	
	public void delete(String productId,String userId);
	
	public void deleteByUserId(String userId);
	
	public WishlistModel save(WishlistModel wishlist) throws WishlistException;
}
