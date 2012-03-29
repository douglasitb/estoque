package com.rhcloud.alexandretavares.estoque.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.rhcloud.alexandretavares.estoque.domain.Peca;
import com.rhcloud.alexandretavares.estoque.domain.TipoDePeca;

public class PecaDAO extends GenericDAOImpl<Peca> {

	@Override
	public Peca find(Long id) {
		return getEntityManager().find(Peca.class, id);
	}

	@Override
	public List<Peca> findAll() {
		TypedQuery<Peca> query = getEntityManager().createNamedQuery("Peca.findAll", Peca.class);
		return query.getResultList();
	}
	
	public Peca findByNome(String nome) {
		TypedQuery<Peca> query = getEntityManager().createNamedQuery("Peca.findByNome", Peca.class);
		query.setParameter(1, nome);
		
		return query.getSingleResult();
	}
	
	public List<Peca> findAllLikeNome(String nome) {
		TypedQuery<Peca> query = getEntityManager().createNamedQuery("Peca.findAllLikeNome", Peca.class);
		query.setParameter(1, "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Peca> findAllByTipoDePeca(TipoDePeca tipoDePeca) {
		TypedQuery<Peca> query = getEntityManager().createNamedQuery("Peca.findAllByTipoDePeca", Peca.class);
		query.setParameter(1, tipoDePeca);
		
		return query.getResultList();
	}
	
	public List<Peca> findAllByTipoDePecaAndLikeDescricao(TipoDePeca tipoDePeca, String descricao) {
		TypedQuery<Peca> query = getEntityManager().createNamedQuery("Peca.findAllByTipoDePecaAndLikeDescricao", Peca.class);
		query.setParameter(1, tipoDePeca);
		query.setParameter(2, "%" + descricao + "%");
		
		return query.getResultList();
	}

}
