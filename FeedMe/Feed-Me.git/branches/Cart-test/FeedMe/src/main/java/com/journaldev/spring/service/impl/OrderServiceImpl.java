package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.OrderDAO;
import com.journaldev.spring.model.Order;
import com.journaldev.spring.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO OrderDAO;

	@Override
	public void add(Order p) {
		this.OrderDAO.add(p);
	}

	@Override
	public void update(Order p) {
		this.OrderDAO.update(p);
	}

	@Override
	public List<Order> list() {
		return this.OrderDAO.list();
	}

	@Override
	public Order getById(Long id) {
		return this.OrderDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.OrderDAO.remove(id);
	}

	@Override
	public Order getByName(String OrderName) {

		return this.OrderDAO.getByName(OrderName);
	}

}
