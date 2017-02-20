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

import com.journaldev.spring.dao.RestaurantDAO;
import com.journaldev.spring.model.Restaurant;
import com.journaldev.spring.model.User;
import com.journaldev.spring.util.SecurePassword;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Restaurant p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Restaurant saved successfully, Restaurant Details=" + p);
	}

	@Override
	public void update(Restaurant p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Restaurant updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Restaurant> RestaurantList = session.createQuery("from Restaurant").getResultList();
		for (Restaurant p : RestaurantList) {
			logger.info("Restaurant List::" + p);
		}
		return RestaurantList;
	}

	@Override
	public Restaurant getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Restaurant p = (Restaurant) session.load(Restaurant.class, id);
		logger.info("Restaurant loaded successfully, Restaurant details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Restaurant p = (Restaurant) session.load(Restaurant.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("Restaurant deleted successfully, Restaurant details=" + p);
	}

	@SuppressWarnings("unchecked")
	public Restaurant getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Restaurant> RestaurantList = new ArrayList<Restaurant>();
		String SQL_QUERY = "from Restaurant u where u.userName = '" + name + "'";
		Query<Restaurant> query = session.createQuery(SQL_QUERY);
		RestaurantList = query.getResultList();
		if (RestaurantList.size() > 0)
			return RestaurantList.get(0);
		else
			return null;
	}
	
	@Override
	public boolean checkLogin(String userName, String userPassword) {

		Session session = sessionFactory.getCurrentSession();
		boolean restFound = false;
		//userPassword=SecurePassword.getSecurePassword(userPassword);
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Restaurant as o where o.userName= '" + userName + "' and o.password= '" + userPassword
				+ "'";
		Query<User> query = session.createQuery(SQL_QUERY);
		List<User> list = query.getResultList();

		if ((list != null) && (list.size() > 0)) {
			restFound = true;
		}

		return restFound;
	}

}
