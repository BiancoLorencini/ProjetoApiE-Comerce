package br.org.serratec.ecommerce.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {
	@Bean
	ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
	
	
}
