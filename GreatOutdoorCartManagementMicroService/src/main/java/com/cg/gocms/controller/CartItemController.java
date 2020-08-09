package com.cg.gocms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gocms.exception.CartItemException;
import com.cg.gocms.model.CartItemModel;
import com.cg.gocms.service.CartItemService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/carts/{userId}")
	public ResponseEntity<List<CartItemModel>> getCartItemsByUserName(@PathVariable("userId") String userId){
		ResponseEntity<List<CartItemModel>> response=null;
		List<CartItemModel> cartItemList=cartItemService.getCartItemsByUserId(userId);
		if(cartItemList==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response=new ResponseEntity<>(cartItemList, HttpStatus.OK);
		}
		return response;
	}

	@PostMapping("/carts/addToCart")
	public ResponseEntity<CartItemModel> addToCart( @RequestBody CartItemModel cartItem) throws CartItemException{
	     cartItem = cartItemService.addToCart(cartItem);
		return new ResponseEntity<>(cartItem,HttpStatus.OK);
		
	}
	@PutMapping("/carts/updateCartItem")
	public ResponseEntity<CartItemModel> updateToCart(@RequestBody CartItemModel cartItem) throws CartItemException{
	     cartItemService.updateQty(cartItem);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@DeleteMapping("/carts/removeProductFromCart/{userId}/{cartId}")
	public ResponseEntity<CartItemModel> deletCartItemsByUserNameAndProductId(@PathVariable("userId") String userId,@PathVariable("cartId") long cartId){
		try {
			cartItemService.removeCartItemsByUserIdAndCartId(userId, cartId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex){
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	
	}
	@DeleteMapping("/carts/removeProductFromCart/{userId}")
  	public ResponseEntity<CartItemModel> deleteCartByUserName(@PathVariable("userName") String userId) {
		try {

			cartItemService.removeAllCartByUserId(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
   }
}
