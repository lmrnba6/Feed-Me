package com.journaldev.spring.dao;

import com.journaldev.spring.model.Restaurant;


public interface RestaurantDAO extends Executer<Restaurant> {

	boolean checkLogin(String userName, String userPassword);
	
}
