package com.microservico.controleestoquepreco.cosumidor.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservico.constantes.RabbitMQConstantes;
import com.microservico.dto.PrecoDto;

@Component
public class PrecoConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_PRECO)
	private void consumir(PrecoDto precoDto) {
		
		System.out.println(precoDto.codigoProduto);
		System.out.println(precoDto.preco);
		System.out.println("-------------------------------------------");
		
	}

}
