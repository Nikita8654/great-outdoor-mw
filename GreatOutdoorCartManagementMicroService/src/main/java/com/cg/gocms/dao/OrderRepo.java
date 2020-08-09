package com.cg.gocms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gocms.entity.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity,Long>{
	
	public List<OrderEntity> findAllByUserId(String userId);
	public OrderEntity findByOrderId(String userId);
	@Modifying
    @Transactional
	@Query("update OrderEntity o set o.dispatchStatus=:statusCode WHERE o.orderId=:order_id")
	void updateDispatchStatus(@Param("order_id") String orderId, @Param("statusCode") int code);
}
