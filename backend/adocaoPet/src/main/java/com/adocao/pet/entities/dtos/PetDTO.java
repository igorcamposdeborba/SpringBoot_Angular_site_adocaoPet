package com.adocao.pet.entities.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.adocao.pet.entities.Ong;
import com.adocao.pet.entities.Pet;
import com.adocao.pet.entities.enums.Gender;
import com.adocao.pet.entities.enums.Health;
import com.adocao.pet.entities.enums.Size;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotNull;

public class PetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotNull (message = "O campo NOME é obrigatório")
	private String name;
	@NotNull (message = "O campo IMAGEM é obrigatório")
	private String image;
	
	@Nullable
	private Size size;
	@Nullable
	private Gender gender;
	@Nullable
	private Set<Health> health = new HashSet<Health>();
	@Nullable
	private String temperament;
	
	// AGREGAÇÃO: para relacionamento
	protected Ong ong; // protected: porque não implementei o get e set porque não uso no momento
	
	// Atributo PARA EVITAR DOIS REQUESTS: Campo salvo pelo Java para evitar outra chamada ao banco de dados (dado está na agregação com a outra tabela, Ong)
	private String nameOng; // Vou usar na tabela para evitar duas requisições (id da linha + nome da Ong)
	
	
	public PetDTO() {
		super();
	}
	
	public PetDTO(Pet petObj) {
		super();
		this.id = petObj.getId();
		this.name = petObj.getName();
		this.image = petObj.getImage();
		this.size = petObj.getSize();
		this.gender = petObj.getGender();
		this.health = petObj.getHealth().stream().map( i -> i).collect(Collectors.toSet());
		this.temperament = petObj.getTemperament();
		this.nameOng = petObj.getOng().getName();
	}
	
	// Métodos de acesso
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImage() {
		return image;
	}
	public Size getSize() {
		return size;
	}
	public Gender getGender() {
		return gender;
	}
	public Set<Health> getHealth(){
		return health;
	}
	public String getTemperament() {
		return temperament;
	}	
	
	// Método da Agregação
	public String getNameOng() {
		return nameOng;
	}
	
}
