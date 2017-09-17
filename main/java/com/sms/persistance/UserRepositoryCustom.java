package com.sms.persistance;

import com.sms.domain.entities.UserEntity;

public interface UserRepositoryCustom {
	
	public void createUser(UserEntity user) ;
	public boolean userExists(String email, String mobile) ;

}
