package com.sms.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sms.persistance.StoredProcedures;
import com.sms.utils.UserStatus;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@Entity(name = "users")
@Table(name = "users")

@ApiModel(value="User Entity", description="Model to hold user information")
public class UsersEntity {
	
	@Id
	
	@Column(name = "user_id")
	private String userId;
	@Column(name = "login_id")
	private String loginId;
	private String email;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@JsonIgnore
	private String passwd;
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
		public static final String USER_NAME = "login_id";
		public static final String USER_ID = "user_id";
		
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
