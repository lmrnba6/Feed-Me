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

import com.journaldev.spring.dao.MenuDAO;
import com.journaldev.spring.model.Menu;

@Repository
public class MenuDAOImpl implements MenuDAO {

	private static final Logger logger = LoggerFactory.getLogger(MenuDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Menu p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Menu saved successfully, Menu Details=" + p);
	}

	@Override
	public void update(Menu p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Menu updated successfully, Menu Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Menu> MenusList = session.createQuery("from Menu").getResultList();
		for (Menu p : MenusList) {
			logger.info("Menu List::" + p);
		}
		return MenusList;
	}

	@Override
	public Menu getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Menu p = (Menu) session.load(Menu.class, id);
		logger.info("Menu loaded successfully, Menu details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Menu p = (Menu) session.load(Menu.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("Menu deleted successfully, Menu details=" + p);
	}

	@SuppressWarnings("unchecked")
	public Menu getByName(String MenuName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Menu> MenuList = new ArrayList<Menu>();
		String SQL_QUERY = "from Menu u where u.restaurant = '" + MenuName + "'";
		Query<Menu> query = session.createQuery(SQL_QUERY);
		MenuList = query.getResultList();
		if (MenuList.size() > 0)
			return MenuList.get(0);
		else
			return null;
	}

}
