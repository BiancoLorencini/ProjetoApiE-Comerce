package br.org.serratec.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.serratec.ecommerce.entities.Pedido;

@Configuration
public class PedidoConfig {
	
	@Bean
	Pedido pedido() {
		return new Pedido();
	}
}
