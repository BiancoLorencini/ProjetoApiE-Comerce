package br.org.serratec.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.serratec.ecommerce.entities.ItemPedido;

@Configuration
public class ItemPedidoConfig {

    @Bean
    ItemPedido itemPedido() {
        return new ItemPedido();
    }
}
