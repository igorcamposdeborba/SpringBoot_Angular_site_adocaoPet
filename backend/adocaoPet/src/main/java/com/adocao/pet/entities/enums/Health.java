package com.adocao.pet.entities.enums;

import java.util.HashSet;
import java.util.Set;

public enum Health {
	VACINADO (0, "vacinado"),
	VERMIFUGADO(1, "vermifugado"),
	CASTRADO (2, "castrado");
	
	private Integer id;
	private Set<String> description = new HashSet<>();
	
	private Health(Integer id, String description) {
		this.id = id;
		this.description.add(description);
	}
	
	public Integer getId() {
		return id;
	}
	
	public Set<String> getAllDescriptions() {
		return description;
	}
	public  void addDescription(Health description) {
		this.description.add(description.toString());
	}
	
	public Health[] toDescription(Integer id) {
		if (description == null) { // exception
			return null;
		}
		
		for (Health i : Health.values()) {
			if (id.equals(i.getId())) {
				return Health.values();
			}
		}
		
		throw new IllegalArgumentException("Estado de saúde inválido");
	}
}
