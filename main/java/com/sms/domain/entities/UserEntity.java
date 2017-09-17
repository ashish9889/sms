package com.sms.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
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
	private String sysCreationDate;
	@Column(name = "sys_update_date")
	private String sysUpdateDate;
	@Column(name = "last_update_by")
	private String lastUpadteBy;

}
