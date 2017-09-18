package com.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.domain.entities.UserEntity;
import com.sms.persistance.UserRepository;
import com.sms.persistance.custom.UserRepositoryCustom;
import com.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Integer createUser(UserEntity user) {
		if (null == user || userRepository.userExists(user.getEmail(), user.getMobile())) {
			return -1;
		}
		Integer status = userRepository.createUser(user.getEmail(), user.getUserName()/*, user.getPassword(), user.getMobile(), user.getAlternateMobile(), user.getSysCreationDate(), user.getStatus(), user.getLastUpadteBy()*/);
		return status;
	}

	@Override
	public UserEntity getUserById(String userId) {
		UserEntity entity = new UserEntity();
		entity.setUserId("123");
		entity.setUserName("ABC");
		return entity;
	}

	@Override
	public Integer updateUserById(UserEntity entity) {
		return userRepository.updateUserByUserId(
				entity);
	}

	@Override
	public Integer deleteUserById(Integer userId) {
		return userRepository.deleteUserByUserId(userId);
	}

	
}
