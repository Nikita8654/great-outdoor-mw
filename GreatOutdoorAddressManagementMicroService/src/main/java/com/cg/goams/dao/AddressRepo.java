package com.cg.goams.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.goams.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity,String>{

	public List<AddressEntity> findAllByUserId(String userId);
}
