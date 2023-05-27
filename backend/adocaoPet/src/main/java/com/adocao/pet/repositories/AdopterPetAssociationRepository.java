package com.adocao.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adocao.pet.entities.AdopterPetAssociation;

//Repository com métodos pré-implementados que se comunicam com o banco de dados
public interface AdopterPetAssociationRepository extends JpaRepository<AdopterPetAssociation, Integer>{
	
}
