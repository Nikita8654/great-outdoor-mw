package com.cg.gowms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gowms.exception.WishlistException;
import com.cg.gowms.model.WishlistModel;
import com.cg.gowms.service.WishlistService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("/wishlist/{userId}")
	public ResponseEntity<List<WishlistModel>> getCartItemsByUserName(@PathVariable("userId") String userId){
		ResponseEntity<List<WishlistModel>> response=null;
		List<WishlistModel> wishList=wishlistService.findAll(userId);
		if(wishList==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response=new ResponseEntity<>(wishList, HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/wishlist/addToWishlist")
	public ResponseEntity<WishlistModel> addToCart( @RequestBody WishlistModel wishlistModel) throws WishlistException{
		wishlistModel= wishlistService.save(wishlistModel);
		return new ResponseEntity<>(wishlistModel,HttpStatus.OK);
		
	}
	@DeleteMapping("/wishlist/deleteWishlist/{productId}/{userId}")
	public ResponseEntity<?> deleteProductfromWishlist(@PathVariable("productId") String productId,@PathVariable("userId") String userId) throws WishlistException{
		WishlistModel tempWishlist = wishlistService.findByIdAndUserId(productId, userId);

		// throw exception if null

		if (tempWishlist == null) {
			throw new WishlistException("Product id not found - " + productId);
		}
		wishlistService.delete(productId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/wishlist/deleteWishlist/{userId}")
	public ResponseEntity<?> deleteAllByUserId(@PathVariable("userId") String userId) {
		try {

			wishlistService.deleteByUserId(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
