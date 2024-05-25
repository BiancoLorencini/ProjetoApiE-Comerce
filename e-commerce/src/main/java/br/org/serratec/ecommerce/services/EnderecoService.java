package br.org.serratec.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.components.ViaCepComponent;
import br.org.serratec.ecommerce.entities.Endereco;
import br.org.serratec.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
    @Autowired
    private ViaCepComponent viaCepService;

	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco save(String cep, Endereco endereco) {
        Endereco enderecoViaCep = viaCepService.getCepInfo(cep);
        if (enderecoViaCep != null) {
            enderecoViaCep.setNumero(endereco.getNumero());
            enderecoViaCep.setComplemento(endereco.getComplemento());
            return enderecoRepository.save(enderecoViaCep);
        } else {
            throw new IllegalArgumentException("CEP não encontrado");
        }
		
	}

	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public boolean deleteById(Integer id) {
		if (enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
			Endereco enderecoDeletado = enderecoRepository.findById(id).orElse(null);
			if (enderecoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return enderecoRepository.count();
	}


}


