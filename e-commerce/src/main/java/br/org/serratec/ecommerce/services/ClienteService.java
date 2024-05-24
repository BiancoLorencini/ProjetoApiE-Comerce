package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.components.CepApiClient;
import br.org.serratec.ecommerce.dtos.ClienteDTO;
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
	
	public List<ClienteDTO> findClienteDto(){
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDto = new ArrayList<>();
		
		for(Cliente cliente : clientes) {
			ClienteDTO clienteDto = new ClienteDTO();
			clienteDto.setNomeCompleto(cliente.getNomeCompleto());
			clienteDto.setEmail(cliente.getEmail());
			clienteDto.setTelefone(cliente.getTelefone());
//			clienteDto.setPedidos(cliente.getPedido());
			
			clientesDto.add(clienteDto);
		}
		return clientesDto;
	}

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}


	public Cliente save(Cliente cliente) {
//	        return clienteRepository.save(cliente);
		
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = cepApiClient.getEnderecoPorCep(cep);

		if (endereco == null || endereco.getCep() == null) {
			throw new RuntimeException("CEP não encontrado");
		}

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
