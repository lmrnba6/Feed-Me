package com.journaldev.spring.service;

import com.journaldev.spring.dao.Executer;
import com.journaldev.spring.model.Restaurant;

public interface RestaurantService extends Executer<Restaurant> {

	boolean checkLogin(String userName, String userPassword);

}
