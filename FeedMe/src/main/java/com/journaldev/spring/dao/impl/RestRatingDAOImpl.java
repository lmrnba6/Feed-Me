package com.journaldev.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.RestRatingDAO;
import com.journaldev.spring.model.RestRating;

@Repository
public class RestRatingDAOImpl implements RestRatingDAO {

	private static final Logger logger = LoggerFactory.getLogger(RestRatingDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(RestRating p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("RestRating saved successfully, RestRating Details=" + p);
	}

	@Override
	public void update(RestRating p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("RestRating updated successfully, RestRating Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestRating> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RestRating> RestRatingsList = session.createQuery("from RestRating").getResultList();
		for (RestRating p : RestRatingsList) {
			logger.info("RestRating List::" + p);
		}
		return RestRatingsList;
	}

	@Override
	public RestRating getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		RestRating p = (RestRating) session.load(RestRating.class, id);
		logger.info("RestRating loaded successfully, RestRating details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		RestRating p = (RestRating) session.load(RestRating.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("RestRating deleted successfully, RestRating details=" + p);
	}

	@SuppressWarnings("unchecked")
	public RestRating getByName(String RestRatingName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<RestRating> RestRatingList = new ArrayList<RestRating>();
		String SQL_QUERY = "from RestRating u where u.RestRatingName = '" + RestRatingName + "'";
		Query<RestRating> query = session.createQuery(SQL_QUERY);
		RestRatingList = query.getResultList();
		if (RestRatingList.size() > 0)
			return RestRatingList.get(0);
		else
			return null;
	}

	@Override
	public List<RestRating> listRestRatingsByRestWithComment(Long id) {
		List<RestRating> ratings = new ArrayList<RestRating>();

		for (RestRating restRating : list()) {
			if (restRating.getRestaurant().getRestId() == id && restRating.getReview()!=null)
				ratings.add(restRating);
		}
		return ratings;
	}
	
	@Override
	public List<RestRating> listRestRatingsByRestWithRating(Long id) {
		List<RestRating> ratings = new ArrayList<RestRating>();

		for (RestRating restRating : list()) {
			if (restRating.getRestaurant().getRestId() == id)
				ratings.add(restRating);
		}
		return ratings;
	}

}
