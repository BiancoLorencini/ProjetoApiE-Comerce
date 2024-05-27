package br.org.serratec.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	List<ItemPedido> findByPedidoIdPedido(Integer idPedido);
}