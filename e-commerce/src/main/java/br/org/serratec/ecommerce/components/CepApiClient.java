package br.org.serratec.ecommerce.components;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.ecommerce.dtos.EnderecoDTO;
import br.org.serratec.ecommerce.entities.Endereco;

@Component
public class CepApiClient {
	private final String API_URL = "https://viacep.com.br/ws/";

	public Endereco getEnderecoPorCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String url = API_URL + cep + "/json";

		Endereco enderecoDto = restTemplate.getForObject(url, Endereco.class);

		if (enderecoDto == null || enderecoDto.getCep() == null) {
			throw new RuntimeException("CEP não encontrado");
		}

			Endereco endereco = new Endereco();
			endereco .setCep(enderecoDto.getCep());
			endereco.setRua(enderecoDto.getLogradouro());
			endereco.setBairro(enderecoDto.getBairro());
			endereco.setCidade(enderecoDto.getLocalidade());
			endereco.setUf(enderecoDto.getUf());
			endereco.setNumero(enderecoDto.getNumero());
			endereco.setComplemento(enderecoDto.getComplemento());
		
			

			return endereco;
	}

}
