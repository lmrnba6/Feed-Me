package com.journaldev.spring.service;

import com.journaldev.spring.dao.Executer;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;

public interface ShoppingCartService extends Executer<ShoppingCart> {
	
	public ShoppingCart getByUser (User user);

}
