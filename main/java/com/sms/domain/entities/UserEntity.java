package com.sms.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.sms.persistance.StoredProcedures;

import lombok.Data;

@Data
@Entity(name = "users")
@Table(name = "users")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = StoredProcedures.user.CREATE_USER_RECORD, procedureName =StoredProcedures.user.CREATE_USER_RECORD, 
			parameters = {
					
					@StoredProcedureParameter (name = UserEntity.paramNames.EMAIL, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.USER_NAME, type = String.class, mode = ParameterMode.IN)
					/*
					@StoredProcedureParameter (name = UserEntity.paramNames.PASSWD, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.MOBILE, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.ALTERNATE_MOBILE, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.SYS_CREATION_DATE, type = Date.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.SYS_UPDATE_DATE, type = Date.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.LAST_UPDATE_BY, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.STATUS, type = String.class, mode = ParameterMode.IN),
					@StoredProcedureParameter (name = UserEntity.paramNames.OUT_STATUS, type = String.class, mode = ParameterMode.OUT*/
	})
})
public class UserEntity {
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_name")
	private String userName;
	private String email;
	private String password;
	private String mobile;
	@Column(name = "alternate_mobile")
	private String alternateMobile;
	@Column(name = "sys_creation_date")
	private Date sysCreationDate;
	@Column(name = "sys_update_date")
	private Date sysUpdateDate;
	@Column(name = "last_update_by")
	private String lastUpadteBy;
	private String status;
	
	public static interface paramNames{
		public static final String USER_NAME = "user_name";
		public static final String EMAIL = "email";
		public static final String PASSWD = "passwd";
		public static final String STATUS = "status";
		public static final String MOBILE = "mobile";
		public static final String ALTERNATE_MOBILE = "alternate_mobile";
		public static final String SYS_CREATION_DATE = "sys_creation_date";
		public static final String SYS_UPDATE_DATE = "sys_update_date";
		public static final String LAST_UPDATE_BY = "last_update_by";
		public static final String OUT_STATUS = "status_id";
		
	}
}
