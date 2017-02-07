package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.User;

public interface Executer<T> {

	public void add(T var1);

	public void update(T var1);

	public List<T> list();

	public T getById(Long var1);

	public T getByName(String var1);

	public void remove(Long var1);

	
}
