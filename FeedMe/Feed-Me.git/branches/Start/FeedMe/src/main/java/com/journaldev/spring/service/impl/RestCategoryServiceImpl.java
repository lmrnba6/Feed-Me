package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.RestCategoryDAO;
import com.journaldev.spring.model.RestCategory;
import com.journaldev.spring.service.RestCategoryService;

@Service
@Transactional
public class RestCategoryServiceImpl implements RestCategoryService {

	@Autowired
	private RestCategoryDAO restCategoryDAO;

	@Override
	public void add(RestCategory p) {
		this.restCategoryDAO.add(p);
	}

	@Override
	public void update(RestCategory p) {
		this.restCategoryDAO.update(p);
	}

	@Override
	public List<RestCategory> list() {
		return this.restCategoryDAO.list();
	}

	@Override
	public RestCategory getById(Long id) {
		return this.restCategoryDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.restCategoryDAO.remove(id);
	}

	@Override
	public RestCategory getByName(String RestCategoryName) {

		return this.restCategoryDAO.getByName(RestCategoryName);
	}

}
