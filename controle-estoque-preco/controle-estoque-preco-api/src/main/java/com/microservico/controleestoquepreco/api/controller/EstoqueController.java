package com.microservico.controleestoquepreco.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservico.constantes.RabbitMQConstantes;
import com.microservico.controleestoquepreco.api.service.RabbitMQService;
import com.microservico.dto.EstoqueDto;

@RestController
@RequestMapping("estoque")
public class EstoqueController {
	
	
	@Autowired
	private RabbitMQService rabbitMQService; 
	
	@PutMapping
	private ResponseEntity<?> alteraEstoque(@RequestBody EstoqueDto estoqueDto ){

		System.out.println(estoqueDto.codigoProduto);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
		return ResponseEntity.status(HttpStatus.OK).body("Estoque alterado com sucesso");
	}

}
