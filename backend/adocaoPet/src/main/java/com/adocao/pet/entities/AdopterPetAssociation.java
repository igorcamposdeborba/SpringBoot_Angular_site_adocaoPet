package com.adocao.pet.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

// Classe associativa que registra a lista de pedidos por data e hora de um Adopter para um Pet.

@Entity
public class AdopterPetAssociation {
	
	private List<Instant> dateRequest; // data e hora (classe Date está deprecated em Java. Substituída por Instant porque aceita UTC e GTM)
	
	// Composição
	@JsonIgnore  // JsonIgnore: para evitar recursao infinita porque as duas classes têm composição uma para a outra
	@JoinColumn(name = "adopter_id") // identifica que a responsabilidade é da classe Adopter e a primaryKey é o id
	List<Adopter> adopter = new ArrayList<Adopter>();
	@JoinColumn(name = "pet_id")
	List<Pet> pet = new ArrayList<Pet>();
	
	public AdopterPetAssociation() {
		this.dateRequest.add(Instant.now()); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção
	}
	
	// Métodos de acesso
	public List<Instant> getDateRequest(){
		return dateRequest;
	}
	public void addDateRequest() {
		this.dateRequest.add(Instant.now());
	}
	
	
	// ! IMPLEMENTAR Hashcode e Equals: para poder adicionar valores comparando os valores dos objetos da lista List<Adopter> e List<Pet> pet
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