package com.adocao.pet.entities.dtos;

import java.io.Serializable;
import java.time.Instant;
import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;
import com.adocao.pet.entities.Pet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

//@Entity
public class AdopterPetAssociationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Instant dateRequest;
	
	@ManyToOne (optional = true, fetch = FetchType.EAGER) // optional: aceita null no relacionamento (que nesse caso é 0=null ou 1)
	protected Pet pet;
	@ManyToOne (optional = true, fetch = FetchType.EAGER)
	protected Adopter adopter;
	
	
	public AdopterPetAssociationDTO() {
		super();
		this.id = null;
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção
	}
	
	public AdopterPetAssociationDTO(AdopterPetAssociation adopterPetAssociation) {
		super();
		this.id = adopterPetAssociation.getId();
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção
		this.adopter = adopterPetAssociation.getAdopter();
		this.pet = adopterPetAssociation.getPet();
	}	
	
	 
	public Integer getId() {
		return id;
	}
	public Instant getDateRequest() {
		return dateRequest;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDateRequest(Instant dateRequest) {
		this.dateRequest = dateRequest;
	}
	
	// Métodos usados no Service AdopterService
	public Adopter getAdopter() {
		return adopter;
	}
	public Pet getPet() {
		return pet;
	}
}
