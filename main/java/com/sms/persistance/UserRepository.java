package com.sms.persistance;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sms.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	public void createUser(UserEntity user);

	public boolean userExists(String email, String password);

	// @Query(value = "select * from users where user_id = :userId", nativeQuery=
	// true)
	public UserEntity findByUserId(String userid);
	public Integer updateUserByUserId(UserEntity entity);
	public Integer deleteUserByUserId(Integer userId);
}
