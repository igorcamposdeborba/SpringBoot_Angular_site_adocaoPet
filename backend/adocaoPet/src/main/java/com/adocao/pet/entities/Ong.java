package com.adocao.pet.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ong implements Serializable { // Serializable para trafegar em rede por bytes
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String telephone;
	private String website;
	private String responsible;
	
	public Ong() { // construtor vazio para superclasse Serializable &&  protected porque o mesmo Package, Classes e Subclasses podem acessar
		super();
	}
	
	public Ong(Integer id, String name, String email, String telephone, String website, String responsible){
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.website = website;
		this.responsible = responsible;
	}
	
	// Métodos de acesso
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getWebsite() {
		return website;
	}
	public String getResponsible() {
		return responsible;
	}
	
	
}
