package com.adocao.pet.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.adocao.pet.entities.dtos.PetDTO;
import com.adocao.pet.entities.enums.Gender;
import com.adocao.pet.entities.enums.Health;
import com.adocao.pet.entities.enums.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

// Dados do Pet já estão cadastrado no banco de dados

@Entity
public class Pet implements Serializable { // Serializable para trafegar em rede por bytes
	private static final long serialVersionUID = 1L;
	
	@Id // define primary key no banco de dados
	@GeneratedValue (strategy = GenerationType.IDENTITY) // Banco de dados gera id
	private Integer id;
	private String name;
	@Column(columnDefinition = "TEXT") // define a coluna  para o tipo TEXT no banco de dados para armazenar grandes strings maios que 255 caracteres
	private String image;
	
	private Size size;
	private Gender gender;
	private Set<Health> health = new HashSet<Health>();
	private Integer age;
	private String temperament;
	
	// Agregação: para relacionamento
	@ManyToOne // Pet conhece a ONG, mas ao contrário não. Por isso não preciso de mappedBy
	private Ong ong;
	
	
	public Pet() { // construtor vazio para superclasse Serializable &&  protected porque Class, Package e Subclass podem acessar
		super();
	}
	
	public Pet(Integer id, String name, String image, Size size, Gender gender, Set<Health> health, Integer age, String temperament, Ong ong) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.size = size;
		this.gender = gender;
		this.health = health;
		this.age = age;
		this.temperament = temperament;
		this.ong = ong;
	}
	
	public Pet(PetDTO petDTO) {
		super();
		this.id = petDTO.getId();
		this.name = petDTO.getName();
		this.image = petDTO.getImage();
		this.size = petDTO.getSize();
		this.gender = petDTO.getGender();
		this.health = petDTO.getHealth();
		this.age = petDTO.getAge();
		this.temperament = petDTO.getTemperament();
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
	public Integer getAge() {
		return age;
	}
	public String getTemperament() {
		return temperament;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setHealth(Set<Health> health) {
		this.health = health;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}
	// Nota: 1) O Pet não conhece seu Adopter porque não há telas (e requests) a partir do pet para saber ou mostrar seu adopter no site 
	
	public Ong getOng() {
		return ong;
	}
	public void setOng(Ong ong) {
		this.ong = ong;
	}
	

	// Hashcode e Equals: para poder adicionar valores comparando os valores dos objetos da lista List<Health>
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(id, other.id);
	}
}
