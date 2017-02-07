package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.CreditCardDAO;
import com.journaldev.spring.model.CreditCard;
import com.journaldev.spring.service.CreditCardService;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	private CreditCardDAO CreditCardDAO;

	@Override
	public void add(CreditCard p) {
		this.CreditCardDAO.add(p);
	}

	@Override
	public void update(CreditCard p) {
		this.CreditCardDAO.update(p);
	}

	@Override
	public List<CreditCard> list() {
		return this.CreditCardDAO.list();
	}

	@Override
	public CreditCard getById(Long id) {
		return this.CreditCardDAO.getById(id);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		this.CreditCardDAO.remove(id);
	}

	@Override
	@Transactional
	public CreditCard getByName(String userId) {

		return this.CreditCardDAO.getByName(userId);
	}

}
