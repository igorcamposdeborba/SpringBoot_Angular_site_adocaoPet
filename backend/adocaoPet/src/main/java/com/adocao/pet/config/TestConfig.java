package com.adocao.pet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.adocao.pet.services.DBService;

@Configuration
@Profile(value = "test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean  // sobe método automaticamente a chamada classe TestConfig
	public void instantiateDataBase() {
		this.dbService.instantiateDataBase();
	}
}
