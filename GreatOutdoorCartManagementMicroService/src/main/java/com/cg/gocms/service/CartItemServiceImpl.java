package com.cg.gocms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gocms.dao.CartRepo;
import com.cg.gocms.entity.CartItemEntity;
import com.cg.gocms.exception.CartItemException;
import com.cg.gocms.model.CartItemModel;
import com.cg.gocms.model.ProductModel;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	private CartRepo repo; 
	@Autowired
	private ProductProxyService productProxyService;
	
	private CartItemEntity of(CartItemModel source) {
		CartItemEntity result=null;
		if(source!=null) {
			result = new CartItemEntity();
			result.setCartId(0);
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
			result.setQuantity(source.getQuantity());
			result.setCartItemPrice(source.getCartItemPrice());
		}
		return result;
	}
    private CartItemModel of(CartItemEntity source) {
    	CartItemModel result=null;
		if(source!=null) {
			result = new CartItemModel();
			result.setCartId(source.getCartId());
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
			result.setQuantity(source.getQuantity());
			result.setCartItemPrice(source.getCartItemPrice());
			
			ProductModel product=productProxyService.getProduct(source.getProductId());
			if(product!=null) {
				result.setProductName(product.getProductName());
				result.setProductCategory(product.getProductCategory());
				result.setProductColor(product.getProductColor());
				result.setActualProductPrice(product.getProductPrice());
			}
			
		}
		return result;
	}
	@Override
	public List<CartItemModel> getCartItemsByUserId(String userId) {
		
		return repo.findAllByUserId(userId).stream().map(this::of).collect(Collectors.toList());
	}

	@Override
	public CartItemModel addToCart(CartItemModel cartItem) throws CartItemException{
		if(cartItem!=null) {
			if(repo.getCartByProductIdAnduserId(cartItem.getProductId(), cartItem.getUserId()).isPresent()){
				throw new CartItemException("Product is already exist in cart.");
			}
			else {
				cartItem=of(repo.save(of(cartItem)));
			}
		}
		return cartItem;
	}
	
	@Override
	public void updateQty(CartItemModel item) throws CartItemException{
		if(!repo.findById(item.getCartId()).isPresent()) {
			throw new CartItemException("Product is not exist in cart.");
		}
		else {
			repo.updateQtyByCartId(item.getCartId(), item.getCartItemPrice(), item.getQuantity());
		}
		
		
	}
	@Override
	public void removeCartItemsByUserIdAndCartId(String userId, long cartId) throws  CartItemException{
		if(!(repo.existsById(cartId))){
			throw new CartItemException("Product is not exist in cart.");
		}
		else {
			repo.deleteCartByIdAndUserId(userId, cartId);
		}
		
		
	}
	@Override
	public void removeAllCartByUserId(String userId) {
		repo.deleteAllCartByUserId(userId);
		
	}
	
	

}
