package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.RestRating;

public interface RestRatingDAO extends Executer<RestRating> {
	
	public List<RestRating> listRestRatingsByRestWithComment(Long id);
	public List<RestRating> listRestRatingsByRestWithRating(Long id);

}
