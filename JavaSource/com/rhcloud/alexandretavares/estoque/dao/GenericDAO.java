package com.rhcloud.alexandretavares.estoque.dao;

import java.util.List;

public interface GenericDAO<E> {

	public void save(E element);
	
	public void update(E element);
	
	public void delete(E element);
	
	public E find(Long id);
	
	public List<E> findAll();
	
}
