package br.org.serratec.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
