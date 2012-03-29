package com.rhcloud.alexandretavares.estoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tipo_de_peca", catalog = "estoque")
@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name = "TipoDePeca.findAll", query = "SELECT tp FROM TipoDePeca tp ORDER BY tp.nome ASC"),
	@NamedQuery(name = "TipoDePeca.findByNome", query = "SELECT tp FROM TipoDePeca tp WHERE tp.nome = ?1")
})
public class TipoDePeca implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Integer version;
	
	@NotNull
	@Length(min = 3, max = 30)
	private String nome;

	public TipoDePeca() {
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

}
