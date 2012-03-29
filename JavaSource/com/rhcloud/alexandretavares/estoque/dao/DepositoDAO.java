package com.rhcloud.alexandretavares.estoque.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.rhcloud.alexandretavares.estoque.domain.Deposito;

public class DepositoDAO extends GenericDAOImpl<Deposito> {

	@Override
	public Deposito find(Long id) {
		return getEntityManager().find(Deposito.class, id);
	}

	@Override
	public List<Deposito> findAll() {
		TypedQuery<Deposito> query = getEntityManager().createNamedQuery("Deposito.findAll", Deposito.class);
		return query.getResultList();
	}
	
	public Deposito findByResponsavel(String responsavel) {
		TypedQuery<Deposito> query = getEntityManager().createNamedQuery("Deposito.findByResponsavel", Deposito.class);
		query.setParameter(1, responsavel);
		
		return query.getSingleResult();
	}

}
