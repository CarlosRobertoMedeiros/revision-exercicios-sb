package br.com.roberto.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	//calculadora/somar/10/20
	//calculadora/subtrair?a=100&b=39
	
	@GetMapping("/somar/{a}/{b}")
	public Long somar(@PathVariable Long a, @PathVariable Long b) {
		return a+b;
	}
	
	@GetMapping("/subtrair")
	public Long subtrair(
			@RequestParam(name = "valor1") Long v1,
			@RequestParam(name = "valor2") Long v2
			) {
		return v1 - v2;
	}
	
	

}
