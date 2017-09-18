package com.sms.persistance.custom;

import java.util.List;

import com.sms.domain.entities.UserEntity;

public interface UserRepositoryCustom {

	public void createUser(UserEntity user);

	public boolean userExists(String email, String mobile);

	public Integer updateUserByUserId(UserEntity entity);

	public List<UserEntity> getAllUser();

	public Integer deleteUserByUserId(Integer userId);
	
	}
