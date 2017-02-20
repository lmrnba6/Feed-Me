package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.RestaurantDAO;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	public void add(Restaurant p) {
		this.restaurantDAO.add(p);
	}

	@Override
	public void update(Restaurant p) {
		this.restaurantDAO.update(p);
	}

	@Override
	public List<Restaurant> list() {
		return this.restaurantDAO.list();
	}

	@Override
	public Restaurant getById(Long id) {
		return this.restaurantDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.restaurantDAO.remove(id);
	}

	@Override
	public Restaurant getByName(String name) {

		return this.restaurantDAO.getByName(name);
	}
	
	@Override
	public boolean checkLogin(String userName, String userPassword) {
		
		return this.restaurantDAO.checkLogin(userName, userPassword);
	}

}
