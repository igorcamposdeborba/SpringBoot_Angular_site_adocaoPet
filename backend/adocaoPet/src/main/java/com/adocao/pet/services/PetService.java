package com.adocao.pet.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adocao.pet.entities.Pet;
import com.adocao.pet.repositories.PetRepository;
import com.adocao.pet.services.exceptions.ObjectNotFoundException;

@Service // injetar instancias em outras partes do código
public class PetService {

	@Autowired // spring intancia objeto injetando dependência
	private PetRepository petRepository;
	

	public Pet findById(Integer id) {
		Optional<Pet> objPet = petRepository.findById(id); // Optional: pode ou não encontrar o valor no banco de dados. Ele Não admite null
		
		return objPet.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado pelo id " + id));
	}

	
	public List<Pet> findAll(){
		List<Pet> petList = petRepository.findAll(); // buscar Pets no banco de dados
		
		return petList;
	}

}
