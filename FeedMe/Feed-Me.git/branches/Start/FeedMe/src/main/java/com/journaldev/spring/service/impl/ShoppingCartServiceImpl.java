package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ShoppingCartDAO;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDAO ShoppingCartDAO;

	@Override
	public void add(ShoppingCart p) {
		this.ShoppingCartDAO.add(p);
	}

	@Override
	public void update(ShoppingCart p) {
		this.ShoppingCartDAO.update(p);
	}

	@Override
	public List<ShoppingCart> list() {
		return this.ShoppingCartDAO.list();
	}

	@Override
	public ShoppingCart getById(Long id) {
		return this.ShoppingCartDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.ShoppingCartDAO.remove(id);
	}

	@Override
	public ShoppingCart getByName(String ShoppingCartName) {

		return this.ShoppingCartDAO.getByName(ShoppingCartName);
	}
	
	@Override
	public ShoppingCart getByUser(User user) {

		return this.ShoppingCartDAO.getByUser(user);
	}

}
