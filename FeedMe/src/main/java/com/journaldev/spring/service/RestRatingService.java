package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.dao.Executer;
import com.journaldev.spring.model.RestRating;

public interface RestRatingService extends Executer<RestRating> {

	public List<RestRating> listRestRatingsByRest(Long id);
}
