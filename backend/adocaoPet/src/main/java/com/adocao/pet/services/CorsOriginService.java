package com.adocao.pet.services;

import java.io.IOException;

import org.springframework.core.annotation.Order;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
@Order(1) // Defina a ordem de execução do filtro
public class CorsOriginService implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response; // cast de ServletResponse para HttpServletResponse (para ficar o mesmo tipo da classe)
		httpResponse.setHeader("Access-Control-Allow-Origin", "*"); // aceita todas as origens de requisição
		httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS"); // aceita somente os métodos usados nesta aplicação
		httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // define os cabeçalhos aceitos no request
		httpResponse.setHeader("Access-Control-Max-Age", "3600"); // 1 hora de tempo de armazenamento no cache para o navagador do cliente
		chain.doFilter(request, response); // aplicar filtros setados
		
	}
	
}
