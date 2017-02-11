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

import com.journaldev.spring.dao.OrderDAO;
import com.journaldev.spring.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Order p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Order saved successfully, Order Details=" + p);
	}

	@Override
	public void update(Order p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Order updated successfully, Order Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> OrdersList = session.createQuery("from Order").getResultList();
		for (Order p : OrdersList) {
			logger.info("Order List::" + p);
		}
		return OrdersList;
	}

	@Override
	public Order getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order p = (Order) session.load(Order.class, id);
		logger.info("Order loaded successfully, Order details=" + p);
		return p;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order p = (Order) session.load(Order.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("Order deleted successfully, Order details=" + p);
	}

	@SuppressWarnings("unchecked")
	public Order getByName(String OrderName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> OrderList = new ArrayList<Order>();
		String SQL_QUERY = "from Order u where u.OrderName = '" + OrderName + "'";
		Query<Order> query = session.createQuery(SQL_QUERY);
		OrderList = query.getResultList();
		if (OrderList.size() > 0)
			return OrderList.get(0);
		else
			return null;
	}

}
