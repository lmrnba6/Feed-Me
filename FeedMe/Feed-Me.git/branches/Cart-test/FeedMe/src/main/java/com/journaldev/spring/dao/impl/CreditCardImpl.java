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

import com.journaldev.spring.dao.CreditCardDAO;
import com.journaldev.spring.model.CreditCard;

@Repository
public class CreditCardImpl implements CreditCardDAO {
	private static final Logger logger = LoggerFactory.getLogger(CreditCardImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void add(CreditCard p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("CreditCard saved successfully, CreditCard Details=" + p);
	}

	public void update(CreditCard p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("CreditCard updated successfully, CreditCard Details=" + p);
	}

	@SuppressWarnings("unchecked")
	public List<CreditCard> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CreditCard> CreditCardsList = session.createQuery("from CreditCard").getResultList();
		for (CreditCard p : CreditCardsList) {
			logger.info("CreditCard List::" + p);
		}
		return CreditCardsList;
	}

	public CreditCard getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		CreditCard p = session.load(CreditCard.class, id);
		logger.info("CreditCard loaded successfully, CreditCard details=" + p);
		return p;
	}

	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		CreditCard p = session.load(CreditCard.class, id);
		if (p != null) {
			session.delete(p);
		}
		logger.info("CreditCard deleted successfully, CreditCard details=" + p);
	}

	@SuppressWarnings("unchecked")
	public CreditCard getByName(String userId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CreditCard> CreditCardList = new ArrayList<CreditCard>();
		String SQL_QUERY = "from CreditCard u where u.user = '" + userId + "'";
		Query<CreditCard> query = session.createQuery(SQL_QUERY);
		CreditCardList = query.getResultList();
		if (CreditCardList.size() > 0) {
			return CreditCardList.get(0);
		}
		return null;
	}
}
