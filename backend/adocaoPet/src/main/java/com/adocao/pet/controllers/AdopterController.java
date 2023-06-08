package com.adocao.pet.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;
import com.adocao.pet.entities.dtos.AdopterDTO;
import com.adocao.pet.services.AdopterService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/adotante")
public class AdopterController {
	
	@Autowired
	protected AdopterService adopterService;
	
	
	// Endpoint POST ADICIONAR Adopter
	@PostMapping (value = "/{idpet}")																 // endpoint recebe/aceita o JSON do formato DTO da classe AdopterDTO
	public ResponseEntity<AdopterDTO> create(@PathVariable Integer idpet, @Valid @RequestBody AdopterDTO objAdopterDTO){ // @Valid valida as annotations @NotNull do AdopterDTO
		
		Adopter newAdopterObj = adopterService.create(idpet, objAdopterDTO); // Salvar na tabela Adopter do banco de dados
		AdopterPetAssociation adopterPetAssociation = adopterService.addPetAdopter(idpet, newAdopterObj); // salvar na tabela associativa AdopterPet
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAdopterObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// Endpoint PUT EDITAR Adopter
	@PutMapping (value = "/{idpet}")
	public ResponseEntity<AdopterDTO> update(@PathVariable Integer idpet, @Valid @RequestBody AdopterDTO adopterDTO ){
		
		Adopter newAdopterObj = adopterService.update(idpet, adopterDTO); // Salvar na tabela Adopter do banco de dados
		AdopterPetAssociation adopterPetAssociation = adopterService.addPetAdopter(idpet, newAdopterObj); // salvar na tabela associativa AdopterPet
		
		return ResponseEntity.ok().body(new AdopterDTO(newAdopterObj)); // Response para o usuário de que atualizou o objeto.  E o objeto foi convertido de DTO para Adopter
	} 
}
