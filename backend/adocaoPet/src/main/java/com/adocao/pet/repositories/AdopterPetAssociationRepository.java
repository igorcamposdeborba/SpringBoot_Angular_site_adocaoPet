package com.adocao.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adocao.pet.entities.AdopterPetAssociation;

public interface AdopterPetAssociationRepository extends JpaRepository<AdopterPetAssociation, Integer>{
	
}
