package com.adocao.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adocao.pet.entities.Adopter;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {

}
