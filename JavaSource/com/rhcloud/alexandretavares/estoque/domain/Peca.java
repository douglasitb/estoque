package com.rhcloud.alexandretavares.estoque.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "peca", catalog = "estoque")
@SuppressWarnings(value = "serial")
@NamedQueries({
	@NamedQuery(name = "Peca.findAllLikeNome", query = "SELECT p FROM Peca p WHERE p.nome LIKE ?1"),
	@NamedQuery(name = "Peca.findByNome", query = "SELECT p FROM Peca p WHERE p.nome = ?1"),
	@NamedQuery(name = "Peca.findAllByTipoDePeca", query = "SELECT p FROM Peca p WHERE p.tipoDePeca = ?1"),
	@NamedQuery(name = "Peca.findAllByTipoDePecaAndLikeDescricao", query = "SELECT p FROM Peca p WHERE p.tipoDePeca = ?1 AND p.descricao LIKE ?2") })
public class Peca implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Integer version;

	@NotNull
	@Length(min = 3, max = 50)
	@Column(unique = true)
	private String nome;

	@NotNull
	@Length(max = 255)
	private String descricao;

	@NotNull
	private Double preco;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "tipo_de_peca_id")
	private TipoDePeca tipoDePeca;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "deposito_id", insertable = false, updatable = false)
	private Deposito deposito;

	public Peca() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoDePeca getTipoDePeca() {
		return tipoDePeca;
	}

	public void setTipoDePeca(TipoDePeca tipoDePeca) {
		this.tipoDePeca = tipoDePeca;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

}
