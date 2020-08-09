package com.cg.gocms.service;

import java.util.List;

import com.cg.gocms.exception.CartItemException;
import com.cg.gocms.model.CartItemModel;

public interface CartItemService {
	
	public List<CartItemModel> getCartItemsByUserId(String userId);
	
	public CartItemModel addToCart(CartItemModel cartItem) throws CartItemException;
	
	public void updateQty(CartItemModel item) throws CartItemException;
	
	public void removeCartItemsByUserIdAndCartId(String userId,long cartId) throws  CartItemException;
	
	public void removeAllCartByUserId(String userId);
}
