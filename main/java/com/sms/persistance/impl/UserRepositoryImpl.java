package com.sms.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.domain.entities.UserEntity;
import com.sms.persistance.UserRepository;
import com.sms.persistance.custom.UserRepositoryCustom;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	UserEntity entity = null;

	public void createUser(UserEntity user) {
		hibernateTemplate.save(user);
	}

	public boolean userExists(String email, String mobile) {
		String hql = "from Users as u where u.email=? and u.mobile=?";
		List<UserEntity> userDetails = (List<UserEntity>) hibernateTemplate.find(hql, email, mobile);
		if (userDetails.size() > 0)
			return true;
		else
			return false;

	}

	public Integer updateUserByUserId(UserEntity entity) {
		String hql="update from com.sms.domain.entities.UserEntity as u"+"set u.userId=?,u.userName=?,u.email=?u.password,u.mobile=?,u.alternateMobile=?"
				+ "where u.userId=?";
		return hibernateTemplate.bulkUpdate(hql,entity.getUserId(),entity.getUserName(),entity.getEmail(),entity.getPassword(),
				entity.getMobile(),entity.getAlternateMobile()) ;
		
	}

	public Integer deleteUserByUserId(Integer userId) {
		String hql="delete from com.sms.domain.entities.UserEntity as u where u.userId=?";
		return hibernateTemplate.bulkUpdate(hql,userId);
	}

	public List<UserEntity> getAllUser() {

		return null;
	}

	
}
