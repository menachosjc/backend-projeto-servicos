package com.menacho.Projeto.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menacho.Projeto.Model.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
