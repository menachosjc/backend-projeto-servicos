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
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
