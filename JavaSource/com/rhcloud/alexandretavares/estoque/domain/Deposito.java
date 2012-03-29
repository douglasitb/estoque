package com.rhcloud.alexandretavares.estoque.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "deposito", catalog = "estoque")
@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"),
	@NamedQuery(name = "Deposito.findByResponsavel", query = "SELECT d FROM Deposito d WHERE d.responsavel = ?1")
})
public class Deposito implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Integer version;
	
	@NotNull
	@Length(min = 3, max = 50)
	@Column(unique = true)
	private String responsavel;

	@NotNull
	@Length(min = 1)
	private Integer capacidade;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "deposito_id")
	private Set<Peca> pecas;

	public Deposito() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Set<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}
