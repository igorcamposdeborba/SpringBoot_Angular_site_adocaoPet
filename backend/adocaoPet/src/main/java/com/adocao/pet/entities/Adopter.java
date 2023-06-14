package com.adocao.pet.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.adocao.pet.entities.dtos.AdopterDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Adopter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@Column(unique = true) // Banco de dados não aceita valores repetidos em diferentes linhas/registro de e-mail
	@NotNull
	private String email;
	@NotNull
	private String telephone;
	
	// Associação: Classe associativa que conecta Pet e Adopter com um atributo compartilhado entre os dois na entity AdopterPetAssociation. Não associar Pet direto em Adopter senão criaria outra tabela.
	@OneToMany (mappedBy = "adopter")
	private Set<AdopterPetAssociation> adopterPetAssociation = new HashSet<AdopterPetAssociation>();
	
	public Adopter() { // construtor vazio para superclasse Serializable &&  protected porque Class, Package e Subclass podem acessar
		super();
	}
	
	public Adopter(Integer id, String name, String email, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}
	
	// CONVERTE ADOPTER DTO para ADOPTER: usado no AdopterService
	public Adopter(AdopterDTO adopterDTO) {
		super();
		this.id = adopterDTO.getId();
		this.name = adopterDTO.getName();
		this.email = adopterDTO.getEmail();
		this.telephone = adopterDTO.getTelephone();
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
	
	public void setId(Integer id) { // Coloquei set Id porque posso receber várias requisições POST para atualizar os atributos baseado no Id (lógica no service)
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Adopter setAdopter(Adopter adopter) {
		this.name = adopter.getName();
		this.email= adopter.getEmail();
		this.telephone = adopter.getTelephone();
		return new Adopter(adopter.getId(), adopter.getName(), adopter.getEmail(), adopter.getTelephone());
	}

	public Set<AdopterPetAssociation> getAllDateRequestAdotation(){
		return adopterPetAssociation;
	}
	
	public void createDateRequestAdotation() {
		this.adopterPetAssociation.add(new AdopterPetAssociation());
	}

	// Hashcode e Equals: para poder adicionar valores comparando os valores dos objetos da lista List<AdopterPetAssociation> e List<Pet> pet
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adopter other = (Adopter) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
