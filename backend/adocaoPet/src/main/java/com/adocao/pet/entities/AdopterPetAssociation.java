package com.adocao.pet.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import com.adocao.pet.entities.dtos.AdopterDTO;
import com.adocao.pet.entities.dtos.PetDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Classe associativa que registra a lista de pedidos por data e hora de um Adopter para um Pet.
// Cada requisição é um Objeto/registro da tabela diferente. Por isso não implemento uma lista.

@Entity
public class AdopterPetAssociation implements Serializable { // Serializable para trafegar em rede por bytes
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Instant dateRequest; // data e hora (classe Date está deprecated em Java. Substituída por Instant porque aceita UTC e GTM)
	
	@ManyToOne (optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_id")
    private Pet pet;

	// @JsonIgnore  ! REVISAR SE COLOCO OU NÃO para evitar loop infinito de reflection
    @ManyToOne (optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    private String adopterName; // Atributos salvos para evitar duas ou mais chamadas ao banco de dados para mostrar o nome do adopter e do pet
    private String petName;
    
	
	public AdopterPetAssociation() {
		super();
		this.id = null;
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção	
	}
	public AdopterPetAssociation(String adopterName) {
		super();
		this.id = null;
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção	
		this.adopterName = adopterName; // Atualizar nome do Adopter
	}
	
	/*public AdopterPetAssociation(Adopter adopter, Pet pet) {
		this.adopter.setId(adopter.getId());	// REVISAR para ver se é para adicionar nesse construtor os atributos do relacionamento das duas entities
		this.adopter.setEmail(adopter.getEmail());
		this.adopter.setName(adopter.getName());
		this.adopter.setTelephone(adopter.getTelephone());
		this.pet.setId(pet.getId());
		this.pet.setName(pet.getName());
		this.pet.setImage(pet.getImage());
		this.pet.setSize(pet.getSize());
		this.pet.setGender(pet.getGender());
		// this.pet.setHealth(pet.getHealth().stream().map( i -> i)).collect(Collectors.toSet());
		this.pet.setAge(pet.getAge());
		this.pet.setTemperament(pet.getTemperament());
	}*/
	
	public AdopterPetAssociation(AdopterDTO adopterDTO, PetDTO petDTO) { // ! REVISAR PARA VER SE PRECISA O ADOPTER DTO AQUI NESSE CONSTRUTOR porque faz exatamente o que o construtor de cima faz
		super();
		this.id = adopterDTO.getId();
		this.dateRequest = Instant.now(); // Ao criar associação do objeto, já adiciona a data atual do pedido de adoção
		
		/*this.adopter.setId(adopterDTO.getId());	// REVISAR para ver se é para adicionar nesse construtor os atributos do relacionamento das duas entities
		this.adopter.setEmail(adopterDTO.getEmail());
		this.adopter.setName(adopterDTO.getName());
		this.adopter.setTelephone(adopterDTO.getTelephone());
		this.pet.setId(petDTO.getId());
		this.pet.setName(petDTO.getName());
		this.pet.setImage(petDTO.getImage());
		this.pet.setSize(petDTO.getSize());
		this.pet.setGender(petDTO.getGender());
		// this.pet.setHealth(petDTO.getHealth().stream().map( i -> i)).collect(Collectors.toSet());
		this.pet.setAge(petDTO.getAge());
		this.pet.setTemperament(petDTO.getTemperament());
		*/
	}
	

	public Instant getDateRequest() {
		return dateRequest;
	}
	public void changeDateRequest(Instant dateRequest) {
		this.dateRequest = dateRequest;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Adopter getAdopter(){
		return adopter;
	}
	public Pet getPet(){
		return pet;
	}
	public void setAdopter(Adopter adopter) { // REVISAR porque já tem o updateAdopter
		this.adopter = adopter;
		this.adopterName = adopter.getName();
	}
	public Adopter updateAdopter(Adopter adopter) { // atualizar nome do Adopter
		this.adopter = adopter;
		this.adopterName = adopter.getName();
		
		return adopter;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
		this.petName = pet.getName();
	}
	
	
	// Hashcode e Equals: para poder adicionar valores comparando os valores dos objetos da lista List<Adopter> e List<Pet> pet
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