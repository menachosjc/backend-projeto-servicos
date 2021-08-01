package com.menacho.Projeto.Rest.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceRealizadoDTO {
	private String descricao;
	private String valor;
	private String data;
	private Integer idCliente;
}
