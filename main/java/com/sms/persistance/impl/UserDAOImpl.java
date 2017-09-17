package com.sms.persistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.domain.entities.UserEntity;
import com.sms.persistance.UserDAO;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void createUser(UserEntity user) {
		hibernateTemplate.save(user);
	}

	public boolean userExists(String email, String mobile) {
		String hql="from Users as u where u.email=? and u.mobile=?";
		List<UserEntity> userDetails =(List<UserEntity>) hibernateTemplate.find(hql,email,mobile);
		if(userDetails.size()>0)
			return true;
		else
		return false;
				
	}

}
