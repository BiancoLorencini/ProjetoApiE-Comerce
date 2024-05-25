package br.org.serratec.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
