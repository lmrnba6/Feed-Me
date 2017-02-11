package com.journaldev.spring.service;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.journaldev.spring.dao.Executer;
import com.journaldev.spring.model.User;

public interface UserService extends Executer<User> {

	public boolean checkLogin(String userName, String userPassword);

}
