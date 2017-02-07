package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.MealRatingDAO;
import com.journaldev.spring.model.MealRating;
import com.journaldev.spring.service.MealRatingService;

@Service
@Transactional
public class MealRatingServiceImpl implements MealRatingService {

	@Autowired
	private MealRatingDAO MealRatingDAO;

	public void setMealRatingDAO(MealRatingDAO MealRatingDAO) {
		this.MealRatingDAO = MealRatingDAO;
	}

	@Override
	public void add(MealRating p) {
		this.MealRatingDAO.add(p);
	}

	@Override
	public void update(MealRating p) {
		this.MealRatingDAO.update(p);
	}

	@Override
	public List<MealRating> list() {
		return this.MealRatingDAO.list();
	}

	@Override
	public MealRating getById(Long id) {
		return this.MealRatingDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.MealRatingDAO.remove(id);
	}

	@Override
	public MealRating getByName(String MealRatingName) {

		return this.MealRatingDAO.getByName(MealRatingName);
	}

}
