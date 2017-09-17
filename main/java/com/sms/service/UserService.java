package com.sms.service;

import com.sms.domain.entities.UserEntity;

public interface UserService {
	public boolean createUser(UserEntity userEntity);
	public UserEntity getUserById(String userId);
	public Boolean updateUser(UserEntity entity);
	public Boolean deleteUser(String userId);
}
