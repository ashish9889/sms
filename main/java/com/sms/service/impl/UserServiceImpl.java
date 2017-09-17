package com.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.domain.entities.UserEntity;
import com.sms.persistance.UserRepository;
import com.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean createUser(UserEntity user) {
		if (null == user || userRepository.userExists(user.getEmail(), user.getMobile())) {
			return false;
		}
		userRepository.createUser(user);
		return true;
	}

	@Override
	public UserEntity getUserById(String userId) {
		UserEntity entity = new UserEntity();
		entity.setUserId("123");
		entity.setUserName("ABC");
		return entity;
	}

	@Override
	public Boolean updateUser(UserEntity entity) {
		return userRepository.updateUserByUserId(entity);
	}

	@Override
	public Boolean deleteUser(String userId) {
		return userRepository.deleteUserByUserId(userId);
	}
}
