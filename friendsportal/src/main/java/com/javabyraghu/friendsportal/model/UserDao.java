package com.javabyraghu.friendsportal.model;

public interface UserDao {

	boolean signUp(User user);

	User signIn(String email, String password);
}
