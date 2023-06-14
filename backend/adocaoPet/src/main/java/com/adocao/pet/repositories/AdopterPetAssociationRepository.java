package com.adocao.pet.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adocao.pet.entities.AdopterPetAssociation;

//Repository com métodos pré-implementados que se comunicam com o banco de dados
public interface AdopterPetAssociationRepository extends JpaRepository<AdopterPetAssociation, Integer>{

	// Adicionados métodos personalizados que são implementado no AdopterService
	@Query("SELECT apa FROM AdopterPetAssociation apa WHERE apa.adopter.id = :adopterId") // Método personalizado por meio de Consulta personalizada com JPQL no banco de dados
	ArrayList<AdopterPetAssociation> findByAdopterId(@Param("adopterId") Integer adopterId); // Busca pelo id do adotante o adotante na tabela associativa AdopterPetAssociation

}
