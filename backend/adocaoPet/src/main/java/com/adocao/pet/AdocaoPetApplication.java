package com.adocao.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@SpringBootApplication
@WebServlet("/api/*")
@ServletComponentScan // listener para a configuração do CORS origin (se estiver executando localmente o Spring Boot e Angular a partir de portas diferentes)
public class AdocaoPetApplication extends HttpServlet  {

	public static void main(String[] args) {
		SpringApplication.run(AdocaoPetApplication.class, args);
	}

}
