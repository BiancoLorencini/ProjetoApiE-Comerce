package br.org.serratec.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.components.CepApiClient;
import br.org.serratec.ecommerce.dtos.EnderecoDTO;
import br.org.serratec.ecommerce.entities.Cliente;
import br.org.serratec.ecommerce.entities.Endereco;
import br.org.serratec.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CepApiClient cepApiClient;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}


	public Cliente save(Cliente cliente) {
//	        return clienteRepository.save(cliente);
		
		String cep = cliente.getEndereco().getCep();
		EnderecoDTO enderecoDto = cepApiClient.getEnderecoPorCep(cep);

		if (enderecoDto == null || enderecoDto.getCep() == null) {
			throw new RuntimeException("CEP não encontrado");
		}

		Endereco endereco = new Endereco();
		endereco.setCep(enderecoDto.getCep());
		endereco.setRua(enderecoDto.getLogradouro());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCidade(enderecoDto.getLocalidade());
		endereco.setUf(enderecoDto.getUf());
		endereco.setNumero(enderecoDto.getNumero());

		cliente.setEndereco(endereco);


		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteClienteById(Integer id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}
}
