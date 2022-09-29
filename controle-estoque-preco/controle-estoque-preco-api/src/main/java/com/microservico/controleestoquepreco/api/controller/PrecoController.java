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
import com.microservico.dto.PrecoDto;

@RestController
@RequestMapping("preco")
public class PrecoController {
	
	
	@Autowired
	private RabbitMQService rabbitMQService; 
	
	@PutMapping
	private ResponseEntity<?> alteraPreco(@RequestBody PrecoDto precoDto ){
		
		System.out.println(precoDto.codigoProduto);
		this.rabbitMQService.enviaMensagem(RabbitMQConstantes .FILA_PRECO, precoDto);
		
		return ResponseEntity.status(HttpStatus.OK).body("Preco alterado com sucesso");
	}

}
