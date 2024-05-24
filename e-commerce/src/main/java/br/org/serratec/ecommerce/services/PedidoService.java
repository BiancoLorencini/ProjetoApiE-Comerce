package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.dtos.PedidoDTO;
import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public List<PedidoDTO> findAllDto() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDTO> pedidosDto = new ArrayList<>();
		
		for(Pedido pedido: pedidos) {
			PedidoDTO pedidoDto = new PedidoDTO();
			pedidoDto.setDataPedido(pedido.getDataPedido());
			pedidoDto.setDataEnvio(pedido.getDataEnvio());
			pedidoDto.setDataEntrega(pedido.getDataEntrega());
			pedidoDto.setStatus(pedido.getStatus());
			pedidoDto.setValorTotal(pedido.getValorTotal());
			pedidoDto.setCliente(pedido.getCliente());
			
			pedidosDto.add(pedidoDto);			
		}
		return pedidosDto;
	}

	public Pedido findById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido update(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public boolean deleteById(Integer id) {
		if (pedidoRepository.existsById(id)) {
			pedidoRepository.deleteById(id);
			Pedido pedidoDeletado = pedidoRepository.findById(id).orElse(null);
			if (pedidoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return pedidoRepository.count();
	}
}

