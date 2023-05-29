package com.adocao.pet.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;

//Repository com métodos pré-implementados que se comunicam com o banco de dados
public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
	
	// Adicionados métodos personalizados que são implementado no AdopterService
	Optional<Adopter> findByEmail(String email); 

	Optional<Adopter> findByName(String name);
	
	Optional<Adopter> findByTelephone(String telephone);
	
	Object[] findTopByOrderByIdDesc(); // Adicionado método personalizado que é implementado no AdopterService para adicionar nova linha
}
