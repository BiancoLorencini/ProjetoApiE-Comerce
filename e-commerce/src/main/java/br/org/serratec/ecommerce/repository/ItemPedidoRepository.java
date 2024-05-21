package br.org.serratec.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.ItemPedido;

public interface ItemPedidoRepository
	extends JpaRepository<ItemPedido,Integer>{
}