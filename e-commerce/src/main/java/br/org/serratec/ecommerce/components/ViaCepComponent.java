package br.org.serratec.ecommerce.components;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import br.org.serratec.ecommerce.entities.Endereco;

@Component
public class ViaCepComponent {

    private static final String VIACEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco getCepInfo(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(VIACEP_URL, Endereco.class, cep);
        System.out.println("Dados recebidos do ViaCep: " + endereco);
        return endereco;
    }

}
