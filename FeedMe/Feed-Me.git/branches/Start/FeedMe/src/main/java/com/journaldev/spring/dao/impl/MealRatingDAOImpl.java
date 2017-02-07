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

import com.journaldev.spring.dao.MealRatingDAO;
import com.journaldev.spring.model.MealRating;

@Repository
public class MealRatingDAOImpl implements MealRatingDAO {

	private static final Logger logger = LoggerFactory.getLogger(MealRatingDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(MealRating p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("MealRating saved successfully, MealRating Details=" + p);
	}

	@Override
	public void update(MealRating p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("MealRating updated successfully, MealRating Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MealRating> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<MealRating> MealRatingsList = session.createQuery("from MealRating").getResultList();
		for (MealRating p : MealRatingsList) {
			logger.info("MealRating List::" + p);
		}
		return MealRatingsList;
	}

	@Override
	public MealRating getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		MealRating p = (MealRating) session.load(MealRating.class, id);
		logger.info("MealRating loaded successfully, MealRating details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		MealRating p = (MealRating) session.load(MealRating.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("MealRating deleted successfully, MealRating details=" + p);
	}

	@SuppressWarnings("unchecked")
	public MealRating getByName(String MealRatingName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<MealRating> MealRatingList = new ArrayList<MealRating>();
		String SQL_QUERY = "from MealRating u where u.MealRatingName = '" + MealRatingName + "'";
		Query<MealRating> query = session.createQuery(SQL_QUERY);
		MealRatingList = query.getResultList();
		if (MealRatingList.size() > 0)
			return MealRatingList.get(0);
		else
			return null;
	}

}
