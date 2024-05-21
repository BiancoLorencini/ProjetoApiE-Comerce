package br.org.serratec.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
