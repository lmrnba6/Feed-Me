package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.FeedBackDAO;
import com.journaldev.spring.model.FeedBack;
import com.journaldev.spring.service.FeedBackService;

@Service
@Transactional
public class FeedBackServiceImpl implements FeedBackService {
	@Autowired
	private FeedBackDAO FeedBackDAO;

	@Override
	public void add(FeedBack p) {
		this.FeedBackDAO.add(p);
	}

	@Override
	public void update(FeedBack p) {
		this.FeedBackDAO.update(p);
	}

	@Override
	public List<FeedBack> list() {
		return this.FeedBackDAO.list();
	}

	@Override
	public FeedBack getById(Long id) {
		return this.FeedBackDAO.getById(id);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		this.FeedBackDAO.remove(id);
	}

	@Override
	@Transactional
	public FeedBack getByName(String FeedBackName) {

		return this.FeedBackDAO.getByName(FeedBackName);
	}

}
