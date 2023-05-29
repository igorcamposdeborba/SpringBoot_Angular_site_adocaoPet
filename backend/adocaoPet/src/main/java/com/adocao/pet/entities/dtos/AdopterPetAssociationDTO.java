package com.adocao.pet.entities.dtos;

import java.io.Serializable;
import java.time.Instant;
import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;
import com.adocao.pet.entities.Pet;

//@Entity
public class AdopterPetAssociationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant dateRequest;
	
	//@ManyToOne (optional = true, fetch = FetchType.EAGER) // optional: aceita null no relacionamento (que nesse caso é 0=null ou 1)
	protected Pet pet;
	//@ManyToOne (optional = true, fetch = FetchType.EAGER)
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
		dateRequest = dateRequest;
	}
	
	// Métodos usados no Service AdopterService
	public Adopter getAdopter() {
		return adopter;
	}
	public Pet getPet() {
		return pet;
	}
}
