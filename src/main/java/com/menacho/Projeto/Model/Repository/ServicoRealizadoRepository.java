package com.menacho.Projeto.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.menacho.Projeto.Model.Entity.ServicoRealizado;

public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado, Integer>{
	
	@Query(" select s from ServicoRealizado s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.data) = :mes ")
	List<ServicoRealizado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
