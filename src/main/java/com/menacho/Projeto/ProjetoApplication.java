package com.menacho.Projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.menacho.Projeto.Model.Entity.Cliente;
import com.menacho.Projeto.Model.Repository.ClienteRepository;

@SpringBootApplication
public class ProjetoApplication {
	@Autowired
	ClienteRepository repository;
	
	@Bean
	public CommandLineRunner run() {
		return args ->{
			Cliente cliente = Cliente.builder().cpf("01866329243").nome("Gabriel").build();
			repository.save(cliente);
		};
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
