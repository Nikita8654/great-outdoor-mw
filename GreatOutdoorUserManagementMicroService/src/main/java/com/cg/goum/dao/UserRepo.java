package com.cg.goum.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.goum.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,String> {
	
	boolean existsByEmail(String email);
	boolean existsByPhoneNo(String phoneNo);
	
	@Query("SELECT u FROM UserEntity u WHERE u.userId=:uId AND u.password=:pass")
	public UserEntity getUser(@Param("uId") String userId,@Param("pass") String password);

}
