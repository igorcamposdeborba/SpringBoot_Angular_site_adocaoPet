package com.adocao.pet.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adocao.pet.entities.Pet;
import com.adocao.pet.entities.dtos.PetDTO;
import com.adocao.pet.services.PetService;

// ENDPOINTS do Controller
@RequestMapping(value = "/catalog")
@RestController
public class PetController {
	
	@Autowired
	protected PetService petService;
	
	// Endpoint GET FIND BY ID
	@GetMapping(value = "/pets/{id}")
	public ResponseEntity<PetDTO> findById(@PathVariable Integer id){ // controla resposta http do servidor (eu especifico header e body)
																	  // retorna o DTO
		Pet objPet = this.petService.findById(id); // buscar objeto no banco de dados
		
		return ResponseEntity.ok().body(new PetDTO(objPet)); // RESPONSE para o usuário do objeto pego do banco de dados
	}
	
	
	// Endpoint GET FIND ALL
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<PetDTO>> findAll(){
		List<Pet> listPet = petService.findAll(); // pegar lista de pets no banco
												  // ! REVISAR: TALVEZ IMPLEMENTAR UM SET (porque não pode ter repetição de pets)
		// Converter para DTO
		List<PetDTO> listPetDTO = new ArrayList<PetDTO>();
		for (Pet obj : listPet) {
			listPetDTO.add(new PetDTO(obj));
		}
		
		return ResponseEntity.ok().body(listPetDTO);
	}
}
