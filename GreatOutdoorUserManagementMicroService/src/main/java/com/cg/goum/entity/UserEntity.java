package com.cg.goum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_user_table")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private String userId;
	@Column(name="password" , nullable=false)
	private String password;
	@Column(name="email" , nullable=false)
	private String email;
	@Column(name="phone_number" , nullable=false)
	private String phoneNo;
	@Column(name="login_token")
	private String loginToken;
	@Column(name="user_role" , nullable=false)
	private String userRole;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLoginToken() {
		return loginToken;
	}
	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

}
