package br.org.serratec.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
