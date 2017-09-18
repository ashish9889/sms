package com.sms.persistance;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.sms.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	@Procedure(procedureName=StoredProcedures.user.CREATE_USER_RECORD, name = StoredProcedures.user.CREATE_USER_RECORD)
	public Integer createUser(@Param(UserEntity.paramNames.EMAIL) String emailId,
			@Param(UserEntity.paramNames.USER_NAME) String userName/*,
			@Param(UserEntity.paramNames.PASSWD) String passwd,
			@Param(UserEntity.paramNames.MOBILE) String mobile,
			@Param(UserEntity.paramNames.ALTERNATE_MOBILE) String alternateMobile,
			@Param(UserEntity.paramNames.SYS_CREATION_DATE) Date sysCreationDate,
			@Param(UserEntity.paramNames.STATUS) String status,
			@Param(UserEntity.paramNames.LAST_UPDATE_BY) String lastUpdateBy*/);
	public boolean userExists(String email, String password);
	public UserEntity findByUserId(String userid);
	public Integer updateUserByUserId(UserEntity entity);
	public Integer deleteUserByUserId(Integer userId);
}
