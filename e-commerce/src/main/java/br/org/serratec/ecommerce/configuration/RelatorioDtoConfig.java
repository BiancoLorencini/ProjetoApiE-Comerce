package br.org.serratec.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.serratec.ecommerce.dtos.RelatorioDTO;

@Configuration
public class RelatorioDtoConfig {
	@Bean
	RelatorioDTO relatorioDto() {
		return new RelatorioDTO();
	}
}
