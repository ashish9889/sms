package com.sms.service;

import com.sms.domain.entities.UserEntity;

public interface UserService {
	public boolean createUser(UserEntity userEntity);
	public UserEntity getUserById(String userId);
	public Integer updateUserById(UserEntity entity);
	public Integer deleteUserById(Integer userId);
}
