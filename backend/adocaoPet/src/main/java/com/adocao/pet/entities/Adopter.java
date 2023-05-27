package com.adocao.pet.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Adopter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String telephone;
	
	// Associação
	//@OneToMany (mappedBy = "pet")
	//private List<Pet> pet = new ArrayList<Pet>();
	@OneToMany (mappedBy = "adopter")
	private List<AdopterPetAssociation> adopterPetAssociation = new ArrayList<AdopterPetAssociation>();
	
	
	public Adopter() { // construtor vazio para superclasse Serializable &&  protected porque Class, Package e Subclass podem acessar
		super();
	}
	
	public Adopter(Integer id, String name, String email, String telephone, AdopterPetAssociation adopterPetAssociation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.adopterPetAssociation.add(adopterPetAssociation); // crio o vínculo do Pet ao Adopter porque o sistema só aceita formulário de request de adoção. 
															   // aqui recebe a data e hora do request para cadastrar na lista
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
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	/*public List<Pet> getPet() {
		return pet;
	}*/
	public List<AdopterPetAssociation> getAllDateRequestAdotation(){
		return adopterPetAssociation;
	}
	/*public void addPet(Pet pet) {
		this.pet.add(pet);
	}*/
	public void createDateRequestAdotation() {
		this.adopterPetAssociation.add(new AdopterPetAssociation());
	}
	public void addDateRequestAdotation() { // sobrecarga do método
		AdopterPetAssociation varRequestAdotation = new AdopterPetAssociation(); // criar objeto de data e hora do request de pedido de adoção
		
		this.adopterPetAssociation.add(varRequestAdotation); // adicionar na lista a data e hora do pedido de adoção
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
