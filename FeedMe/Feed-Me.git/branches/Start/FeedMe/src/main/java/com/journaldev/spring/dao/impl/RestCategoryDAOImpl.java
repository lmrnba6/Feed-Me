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

import com.journaldev.spring.dao.RestCategoryDAO;
import com.journaldev.spring.model.RestCategory;

@Repository
public class RestCategoryDAOImpl implements RestCategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(RestCategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(RestCategory p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("RestCategory saved successfully, User Details=" + p);
	}

	@Override
	public void update(RestCategory p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("RestCategory updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestCategory> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RestCategory> RestCategoryList = session.createQuery("from RestCategory").getResultList();
		for (RestCategory p : RestCategoryList) {
			logger.info("RestCategory List::" + p);
		}
		return RestCategoryList;
	}

	@Override
	public RestCategory getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		RestCategory p = (RestCategory) session.load(RestCategory.class, id);
		logger.info("RestCategory loaded successfully, RestCategory details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		RestCategory p = (RestCategory) session.load(RestCategory.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("RestCategory deleted successfully, RestCategory details=" + p);
	}

	@SuppressWarnings("unchecked")
	public RestCategory getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<RestCategory> RestCategoryList = new ArrayList<RestCategory>();
		String SQL_QUERY = "from RestCategory u where u.name = '" + name + "'";
		Query<RestCategory> query = session.createQuery(SQL_QUERY);
		RestCategoryList = query.getResultList();
		if (RestCategoryList.size() > 0)
			return RestCategoryList.get(0);
		else
			return null;
	}

}
