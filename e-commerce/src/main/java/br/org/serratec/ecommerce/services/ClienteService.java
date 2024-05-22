package br.org.serratec.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.entities.Cliente;
import br.org.serratec.ecommerce.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}

	@Transactional
	public Cliente save(Cliente cliente) {
	      if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
	            throw new RuntimeException("Já existe um cliente com este CPF.");
	        }
	        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
	            throw new RuntimeException("Já existe um cliente com este email.");
	        }
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
