package com.journaldev.spring.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.User;
import com.journaldev.spring.util.SecurePassword;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLogin(String userName, String userPassword) {

		Session session = sessionFactory.getCurrentSession();
		boolean userFound = false;
		userPassword=SecurePassword.getSecurePassword(userPassword);
		// Query using Hibernate Query Language
		String SQL_QUERY = " from User as o where o.userName= '" + userName + "' and o.userPassword= '" + userPassword
				+ "'";
		Query<User> query = session.createQuery(SQL_QUERY);
		List<User> list = query.getResultList();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		return userFound;
	}

	@Override
	public void add(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details=" + p);
	}

	@Override
	public void update(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> UsersList = session.createQuery("from User").getResultList();
		for (User p : UsersList) {
			logger.info("User List::" + p);
		}
		return UsersList;
	}

	@Override
	public User getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		/*User user = session.createQuery("from User u left join fetch u.cart c left join fetch c.meals m where u.id = :id", User.class)
				.setParameter("id", id)
				.getSingleResult(); */
		User user = (User) session.load(User.class, id);
		logger.info("User loaded successfully, User details=" + user);
		return user;
	}

	@Override
	public void remove(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		if (null != p) {
			session.delete(p);
		}
		logger.info("User deleted successfully, User details=" + p);
	}

	@SuppressWarnings("unchecked")
	public User getByName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = new ArrayList<User>();
		String SQL_QUERY = "from User u where u.userName = '" + userName + "'";
		Query<User> query = session.createQuery(SQL_QUERY);
		userList = query.getResultList();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

}
