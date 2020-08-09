package com.cg.gowms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gowms.dao.WishlistRepository;
import com.cg.gowms.entity.WishlistEntity;
import com.cg.gowms.exception.WishlistException;
import com.cg.gowms.model.ProductModel;
import com.cg.gowms.model.WishlistModel;

@Service
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	private ProductProxyService productProxyService;
	
	private WishlistEntity of(WishlistModel source) {
		WishlistEntity result=null;
		if(source!=null) {
			result=new WishlistEntity();
			result.setWishListId(0);
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
		}
		return result;
	}
	private WishlistModel of(WishlistEntity source) {
		WishlistModel result=null;
		if(source!=null) {
			result=new WishlistModel();
			result.setWishListId(source.getWishListId());
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
			
			ProductModel product=productProxyService.getProduct(source.getProductId());
			if(product!=null) {
				result.setProductName(product.getProductName());
				result.setProductCategory(product.getProductCategory());
				result.setProductColor(product.getProductColor());
				result.setProductPrice(product.getProductPrice());
				result.setProductSpecification(product.getProductSpecification());
				result.setProductQuantity(product.getProductQuantity());
			}
		}
		return result;
	}
	@Override
	public List<WishlistModel> findAll(String userId) {
		
		return wishlistRepo.findAllByUserId(userId).stream().map(this::of).collect(Collectors.toList());
	}

	@Override
	public void delete(String productId, String userId) {
		wishlistRepo.deleteIdAndUserId(userId, productId);
		
	}

	@Override
	public WishlistModel save(WishlistModel wishlist) throws WishlistException{
	
			return of( wishlistRepo.save(of(wishlist)));
		
		
		
	}
	@Override
	public void deleteByUserId(String userId) {
		
		wishlistRepo.deleteByUserId(userId);
	}
	@Override
	public WishlistModel findByIdAndUserId(String productId, String userId) {

		return of(wishlistRepo.findByIdAndUserId(productId, userId));
	}

}
