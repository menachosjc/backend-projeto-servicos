package com.menacho.Projeto.Rest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.menacho.Projeto.Model.Entity.Cliente;
import com.menacho.Projeto.Model.Entity.ServicoRealizado;
import com.menacho.Projeto.Model.Repository.ClienteRepository;
import com.menacho.Projeto.Model.Repository.ServicoRealizadoRepository;
import com.menacho.Projeto.Rest.Dto.ServiceRealizadoDTO;
import com.menacho.Projeto.Util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-realizados")
@RequiredArgsConstructor
public class ServicoRealizadoController {

	private final ClienteRepository clienteRepository;
	private final ServicoRealizadoRepository servicoRepository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ServicoRealizado salvar(@RequestBody ServiceRealizadoDTO dto) {
		ServicoRealizado servico = new ServicoRealizado();
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));		
		
		servico.setDescricao(dto.getDescricao());
		servico.setData(data);
		servico.setCliente(cliente);
		servico.setValor(bigDecimalConverter.converter(dto.getValor()));
		
		return servicoRepository.save(servico);
	}
	
	@GetMapping
	public List<ServicoRealizado> buscar(
			@RequestParam(value = "nome", required = false) String nome, 
			@RequestParam(value = "mes", required = false) Integer mes 
	){			
		return servicoRepository.findByNomeClienteAndMes("%"+nome+"%", mes);		
	}
}
