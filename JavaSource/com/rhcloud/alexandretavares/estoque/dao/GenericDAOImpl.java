package com.rhcloud.alexandretavares.estoque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

public abstract class GenericDAOImpl<E> implements GenericDAO<E> {

	@PersistenceContext
	private EntityManager entityManager;
	private Logger logger;

	public GenericDAOImpl() {
		this.logger = Logger.getLogger(GenericDAOImpl.class);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void save(E element) {
		try {
			entityManager.persist(element);	
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void update(E element) {
		save(element);
	}

	@Override
	public void delete(E element) {
		try {
			entityManager.remove(element);	
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
