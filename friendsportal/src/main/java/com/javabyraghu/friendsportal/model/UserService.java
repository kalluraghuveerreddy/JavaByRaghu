package com.javabyraghu.friendsportal.model;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserService implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean signUp(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User signIn(String email, String password) {
		try {
			Query<User> query = sessionFactory.getCurrentSession()
					.createQuery("from User where email=:email and password=:password", User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
