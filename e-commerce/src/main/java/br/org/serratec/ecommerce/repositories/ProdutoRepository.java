package br.org.serratec.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
