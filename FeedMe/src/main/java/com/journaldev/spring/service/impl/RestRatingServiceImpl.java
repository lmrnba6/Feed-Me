package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.RestRatingDAO;
import com.journaldev.spring.model.RestRating;
import com.journaldev.spring.service.RestRatingService;

@Service
@Transactional
public class RestRatingServiceImpl implements RestRatingService {

	@Autowired
	private RestRatingDAO RestRatingDAO;

	@Override
	public void add(RestRating p) {
		this.RestRatingDAO.add(p);
	}

	@Override
	public void update(RestRating p) {
		this.RestRatingDAO.update(p);
	}

	@Override
	public List<RestRating> list() {
		return this.RestRatingDAO.list();
	}

	@Override
	public RestRating getById(Long id) {
		return this.RestRatingDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.RestRatingDAO.remove(id);
	}

	@Override

	public RestRating getByName(String RestRatingName) {

		return this.RestRatingDAO.getByName(RestRatingName);
	}

	@Override
	public List<RestRating> listRestRatingsByRestWithComment(Long id) {

		return this.RestRatingDAO.listRestRatingsByRestWithComment(id);
	}
	
	@Override
	public List<RestRating> listRestRatingsByRestWithRating(Long id) {

		return this.RestRatingDAO.listRestRatingsByRestWithRating(id);
	}

}
