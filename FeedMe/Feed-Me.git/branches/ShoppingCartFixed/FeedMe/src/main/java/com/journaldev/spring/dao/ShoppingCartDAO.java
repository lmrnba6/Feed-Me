package com.journaldev.spring.dao;

import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;

public interface ShoppingCartDAO extends Executer<ShoppingCart>{
	
	public ShoppingCart getByUser (User user);
	
}
