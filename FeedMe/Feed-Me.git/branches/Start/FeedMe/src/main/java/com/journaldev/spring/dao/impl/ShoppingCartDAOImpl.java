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

import com.journaldev.spring.dao.ShoppingCartDAO;
import com.journaldev.spring.model.ShoppingCart;
import com.journaldev.spring.model.User;

@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(ShoppingCart p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("ShoppingCart saved successfully, ShoppingCart Details=" + p);
	}

	@Override
	public void update(ShoppingCart p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("ShoppingCart updated successfully, ShoppingCart Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ShoppingCart> ShoppingCartsList = session.createQuery("from ShoppingCart").getResultList();
		for (ShoppingCart p : ShoppingCartsList) {
			logger.info("ShoppingCart List::" + p);
		}
		return ShoppingCartsList;
	}

	@Override
	public ShoppingCart getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ShoppingCart p = (ShoppingCart) session.load(ShoppingCart.class, id);
		logger.info("ShoppingCart loaded successfully, ShoppingCart details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ShoppingCart p = (ShoppingCart) session.load(ShoppingCart.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("ShoppingCart deleted successfully, ShoppingCart details=" + p);
	}

	@SuppressWarnings("unchecked")
	public ShoppingCart getByName(String ShoppingCartName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ShoppingCart> ShoppingCartList = new ArrayList<ShoppingCart>();
		String SQL_QUERY = "from ShoppingCart u where u.ShoppingCartName = '" + ShoppingCartName + "'";
		Query<ShoppingCart> query = session.createQuery(SQL_QUERY);
		ShoppingCartList = query.getResultList();
		if (ShoppingCartList.size() > 0)
			return ShoppingCartList.get(0);
		else
			return null;
	}
	
	public ShoppingCart getByUser (User user){
		
		for (ShoppingCart cart : list()) {
			if(cart.getUser().getUserId()==user.getUserId())
				return cart;
		}
		
		return null;
		
	}

}
