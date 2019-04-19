package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.UserDetail;
@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public UserDetail getUserDetail(String username) 
	{
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	@Override
	public boolean updateUser(UserDetail user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
