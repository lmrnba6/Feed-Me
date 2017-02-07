package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.MealDAO;
import com.journaldev.spring.model.Meal;
import com.journaldev.spring.service.MealService;

@Service
@Transactional
public class MealServiceImpl implements MealService {

	@Autowired
	private MealDAO MealDAO;

	@Override
	public void add(Meal p) {
		this.MealDAO.add(p);
	}

	@Override
	public void update(Meal p) {
		this.MealDAO.update(p);
	}

	@Override
	public List<Meal> list() {
		return this.MealDAO.list();
	}

	@Override
	public Meal getById(Long id) {
		return this.MealDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.MealDAO.remove(id);
	}

	@Override
	public Meal getByName(String MealName) {

		return this.MealDAO.getByName(MealName);
	}

}
