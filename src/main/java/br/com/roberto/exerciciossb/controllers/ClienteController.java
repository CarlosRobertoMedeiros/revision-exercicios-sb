package br.com.roberto.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28L, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId(@PathVariable Long id) {
		return new Cliente(id, "Pedro", "123.456.789-00");
	}
	
	@GetMapping()
	public Cliente obterClientePorId2(
			@RequestParam(name="id", defaultValue = "1") Long id) {
		return new Cliente(id, "João da Silva", "111.222.333-44");
	}

}
