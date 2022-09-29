package com.microservico.controleestoquepreco.cosumidor.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservico.constantes.RabbitMQConstantes;
import com.microservico.dto.EstoqueDto;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumir(EstoqueDto estoqueDto) {
		
		System.out.println(estoqueDto.codigoProduto);
		System.out.println(estoqueDto.quantidade);
		System.out.println("-------------------------------------------");
		
	}

}
