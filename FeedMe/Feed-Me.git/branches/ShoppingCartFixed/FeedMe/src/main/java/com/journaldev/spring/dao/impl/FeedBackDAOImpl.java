package com.journaldev.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.FeedBackDAO;
import com.journaldev.spring.model.FeedBack;

@Repository
public class FeedBackDAOImpl implements FeedBackDAO {
	private static final Logger logger = LoggerFactory.getLogger(FeedBackDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void add(FeedBack p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("FeedBack saved successfully, FeedBack Details=" + p);
	}

	public void update(FeedBack p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("FeedBack updated successfully, FeedBack Details=" + p);
	}

	@SuppressWarnings("unchecked")
	public List<FeedBack> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FeedBack> FeedBacksList = session.createQuery("from FeedBack").getResultList();
		for (FeedBack p : FeedBacksList) {
			logger.info("FeedBack List::" + p);
		}
		return FeedBacksList;
	}

	public FeedBack getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		FeedBack p = session.load(FeedBack.class, id);
		logger.info("FeedBack loaded successfully, FeedBack details=" + p);
		return p;
	}

	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		FeedBack p = session.load(FeedBack.class, id);
		if (p != null) {
			session.delete(p);
		}
		logger.info("FeedBack deleted successfully, FeedBack details=" + p);
	}

	@SuppressWarnings("unchecked")
	public FeedBack getByName(String FeedBackName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<FeedBack> FeedBackList = new ArrayList<FeedBack>();
		String SQL_QUERY = "from FeedBack u where u.FeedBackName = '" + FeedBackName + "'";
		Query<FeedBack> query = session.createQuery(SQL_QUERY);
		FeedBackList = query.getResultList();
		if (FeedBackList.size() > 0) {
			return FeedBackList.get(0);
		}
		return null;
	}
}
