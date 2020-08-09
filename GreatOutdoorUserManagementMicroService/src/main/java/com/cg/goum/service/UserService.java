package com.cg.goum.service;

import com.cg.goum.exception.UserException;
import com.cg.goum.model.UserModel;

public interface UserService {
	
	public UserModel userRegistration(UserModel user)  throws UserException;
	public UserModel userLogin(String userId, String password)  throws UserException;

}
