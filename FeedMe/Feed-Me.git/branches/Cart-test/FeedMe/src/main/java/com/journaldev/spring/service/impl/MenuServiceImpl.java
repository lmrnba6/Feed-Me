package com.journaldev.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.MenuDAO;
import com.journaldev.spring.model.Menu;
import com.journaldev.spring.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO MenuDAO;

	@Override
	public void add(Menu p) {
		this.MenuDAO.add(p);
	}

	@Override
	public void update(Menu p) {
		this.MenuDAO.update(p);
	}

	@Override
	public List<Menu> list() {
		return this.MenuDAO.list();
	}

	@Override
	public Menu getById(Long id) {
		return this.MenuDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.MenuDAO.remove(id);
	}

	@Override
	public Menu getByName(String MenuName) {

		return this.MenuDAO.getByName(MenuName);
	}

}
