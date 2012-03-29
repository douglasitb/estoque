package com.rhcloud.alexandretavares.estoque.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TipoDePecaBean {

	public TipoDePecaBean() {
		// TODO Auto-generated constructor stub
	}

	public String getInformacao() {
		return "Teste do primeiro Bean";
	}
	
	public void salvar() {
		System.out.println("Salvando");
	}
	
	public String novo() {
		return "create";
	}
}
