package com.adocao.pet.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import com.adocao.pet.entities.dtos.AdopterDTO;
import com.adocao.pet.entities.dtos.PetDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Classe associativa que registra a lista de pedidos por data e hora de um Adopter para um Pet.
// Cada requisição é um Objeto/registro da tabela diferente. Por isso não implemento uma lista.

@Entity
public class AdopterPetAssociation implements Serializable { // Serializable para trafegar em rede por bytes
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Instant dateRequest; // data e hora (classe Date está deprecated em Java. Substituída por Instant porque aceita UTC e GTM)
	
	@ManyToOne (optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne (optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    protected String adopterName; // Atributos salvos para evitar duas ou mais chamadas ao banco de dados para mostrar o nome do adopter e do pet
    protected String petName;
    
	
	public AdopterPetAssociation() {
		super();
		this.id = null;
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção	
	}
	public AdopterPetAssociation(String adopterName) {
		super();
		this.id = null;
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção	
		this.adopterName = adopterName; // Atualizar nome do Adopter
	}
	
	public AdopterPetAssociation(AdopterDTO adopterDTO, PetDTO petDTO) {
		super();
		this.id = adopterDTO.getId();
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção
	}
	

	public Instant getDateRequest() {
		return dateRequest;
	}
	public void changeDateRequest(Instant dateRequest) {
		this.dateRequest = dateRequest;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Adopter getAdopter(){
		return adopter;
	}
	public Pet getPet(){
		return pet;
	}
	public void setAdopter(Adopter adopter) { // REVISAR porque já tem o updateAdopter
		this.adopter = adopter;
		this.adopterName = adopter.getName();
	}
	public Adopter updateAdopter(Adopter adopter) { // atualizar nome do Adopter
		this.adopter = adopter;
		this.adopterName = adopter.getName();
		
		return adopter;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
		this.petName = pet.getName();
	}
	
	
	// Hashcode e Equals: para poder adicionar valores comparando os valores dos objetos da lista List<Adopter> e List<Pet> pet
	@Override
	public int hashCode() {
		return Objects.hash(pet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdopterPetAssociation other = (AdopterPetAssociation) obj;
		return Objects.equals(pet, other.pet);
	}

}