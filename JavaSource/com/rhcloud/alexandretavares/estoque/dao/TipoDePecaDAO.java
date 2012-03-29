package com.rhcloud.alexandretavares.estoque.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.rhcloud.alexandretavares.estoque.domain.TipoDePeca;

public class TipoDePecaDAO extends GenericDAOImpl<TipoDePeca> {

	@Override
	public TipoDePeca find(Long id) {
		return getEntityManager().find(TipoDePeca.class, id);
	}

	@Override
	public List<TipoDePeca> findAll() {
		TypedQuery<TipoDePeca> query = getEntityManager().createNamedQuery("TipoDePeca.findAll", TipoDePeca.class);
		return query.getResultList();
	}
	
	public TipoDePeca findByNome(String nome) {
		TypedQuery<TipoDePeca> query = getEntityManager().createNamedQuery("TipoDePeca.findByNome", TipoDePeca.class);
		query.setParameter(1, nome);
		
		return query.getSingleResult();
	}

}
