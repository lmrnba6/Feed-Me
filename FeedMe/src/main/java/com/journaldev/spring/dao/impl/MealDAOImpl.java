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

import com.journaldev.spring.dao.MealDAO;
import com.journaldev.spring.model.Meal;

@Repository
public class MealDAOImpl implements MealDAO {

	private static final Logger logger = LoggerFactory.getLogger(MealDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Meal p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Meal saved successfully, Meal Details=" + p);
	}

	@Override
	public void update(Meal p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Meal updated successfully, Meal Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meal> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Meal> MealsList = session.createQuery("from Meal").getResultList();
		for (Meal p : MealsList) {
			logger.info("Meal List::" + p);
		}
		return MealsList;
	}

	@Override
	public Meal getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Meal p = (Meal) session.load(Meal.class, id);
		logger.info("Meal loaded successfully, Meal details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Meal p = (Meal) session.load(Meal.class, id);
		Query query = session.createQuery("delete from meal u left join fetch menu where u.meal_id =:id").setParameter("id", id); 
		int result = query.executeUpdate();
		/*if (null != p) {
			session.delete(p);
		}			     	 
	    
		logger.info("Meal deleted successfully, Meal details=" + p);*/
	}

	@SuppressWarnings("unchecked")
	public Meal getByName(String MealName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Meal> MealList = new ArrayList<Meal>();
		String SQL_QUERY = "from Meal u where u.MealName = '" + MealName + "'";
		Query<Meal> query = session.createQuery(SQL_QUERY);
		MealList = query.getResultList();
		if (MealList.size() > 0)
			return MealList.get(0);
		else
			return null;
	}

}
