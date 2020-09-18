package com.javabyraghu.friendsportal.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javabyraghu.friendsportal.config.PersistanceConfiguration;
import com.javabyraghu.friendsportal.model.User;
import com.javabyraghu.friendsportal.model.UserDao;

@SpringJUnitConfig(classes = { PersistanceConfiguration.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() {

		user.setName("Dhoni");
		user.setEmail("dhoni.@icc.gov.in");
		user.setGender("Male");
		user.setMobile("969696696");
		user.setPassword("12345678");
		user.setAge("39");
	}

	@Test
	public void testUser() {
		assertEquals("Registered Successfully", true, userDao.signUp(user));
	}
}
