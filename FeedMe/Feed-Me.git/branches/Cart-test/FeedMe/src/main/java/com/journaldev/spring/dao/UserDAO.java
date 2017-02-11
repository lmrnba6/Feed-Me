package com.journaldev.spring.dao;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.journaldev.spring.model.User;

public interface UserDAO extends Executer<User> {

	public boolean checkLogin(String userName, String userPassword);

}
