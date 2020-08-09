package com.cg.gocms.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gocms.entity.CartItemEntity;


@Repository
public interface CartRepo extends JpaRepository<CartItemEntity,Long>{
	
	public List<CartItemEntity> findAllByUserId(String userId);
	
	@Query("Select sum(c.cartItemPrice) FROM CartItemEntity c WHERE c.userId=:user_id")
	double getTotalAmountByUserId(@Param("user_id") String userId);
	
	@Modifying
    @Transactional
	@Query("update CartItemEntity addCart set addCart.quantity=:qty,addCart.cartItemPrice=:price WHERE addCart.cartId=:cart_id")
	void updateQtyByCartId(@Param("cart_id") long cartId, @Param("price") double cartItemPrice,@Param("qty") long quantity);
	
	@Query("Select addCart  FROM CartItemEntity addCart WHERE addCart.productId= :product_id and addCart.userId=:user_id")
	Optional<CartItemEntity> getCartByProductIdAnduserId(@Param("product_id") String productId,@Param("user_id") String userId);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM CartItemEntity c WHERE c.cartId =:cart_id   and c.userId=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")String userId,@Param("cart_id")long cartId);
	@Modifying
    @Transactional
	@Query("DELETE  FROM CartItemEntity c WHERE   c.userId=:user_id")
	void deleteAllCartByUserId(@Param("user_id")String userId);
	


}
