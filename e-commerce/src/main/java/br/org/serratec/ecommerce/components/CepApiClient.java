package br.org.serratec.ecommerce.components;

import br.org.serratec.ecommerce.dtos.EnderecoDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CepApiClient {
    private final String API_URL = "https://viacep.com.br/ws/";

    public EnderecoDTO getEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + cep + "/json";
        return restTemplate.getForObject(url, EnderecoDTO.class);
    }

}
