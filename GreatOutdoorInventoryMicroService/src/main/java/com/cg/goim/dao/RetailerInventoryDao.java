package com.cg.goim.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.goim.entity.RetailerInventoryEntity;



@Repository
public interface RetailerInventoryDao extends JpaRepository<RetailerInventoryEntity,String> {
  

   List<RetailerInventoryEntity> findAllByRetailerId(String retailerId);
   
   @Query("select  r from RetailerInventoryEntity r where r.productId=:pid and r.retailerId=:rid")
   Optional<RetailerInventoryEntity> findByProductIdAndRetailerId(@Param("pid")String productId,@Param("rid")String retailerId);
}
