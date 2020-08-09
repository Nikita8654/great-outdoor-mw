package com.cg.gowms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gowms.entity.WishlistEntity;


@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity,Long>{
	
	public List<WishlistEntity> findAllByUserId(String userId);
	
	@Query("select w from WishlistEntity w where w.userId=:uid and w.productId=:pid")
	WishlistEntity findByIdAndUserId(@Param("pid") String productId,@Param("uid")String userId);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM WishlistEntity w WHERE w.productId =:pid   and w.userId=:uid")
	void deleteIdAndUserId(@Param("uid")String userId,@Param("pid") String productId);
	
	@Modifying
    @Transactional
	@Query("DELETE FROM WishlistEntity w WHERE w.userId=:uid")
	void deleteByUserId(@Param("uid")String userId);

}
