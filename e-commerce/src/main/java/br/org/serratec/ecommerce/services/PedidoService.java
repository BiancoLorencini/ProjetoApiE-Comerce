package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.dtos.PedidoDTO;
import br.org.serratec.ecommerce.dtos.RelatorioDTO;
import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.enums.StatusPedido;
import br.org.serratec.ecommerce.repositories.ItemPedidoRepository;
import br.org.serratec.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	RelatorioService relatorioService;
	
	@Autowired
	Pedido pedido;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmailService emailService;

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public List<PedidoDTO> findAllDto() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDTO> pedidosDto = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			PedidoDTO pedidoDto = new PedidoDTO();
			pedidoDto.setDataPedido(pedido.getDataPedido());
			pedidoDto.setDataEnvio(pedido.getDataEnvio());
			pedidoDto.setDataEntrega(pedido.getDataEntrega());
			pedidoDto.setStatus(pedido.getStatusPedido());
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
		Pedido pedidoAntigo = pedidoRepository.findById(pedido.getIdPedido()).get();
		
		pedidoAntigo.setStatusPedido(pedido.getStatusPedido());
		pedidoAntigo.setDataEntrega(pedido.getDataEntrega());
		pedidoAntigo.setDataEnvio(pedido.getDataEnvio());
		pedidoAntigo.setDataPedido(pedido.getDataPedido());
		
		Pedido pedidoSalvo = pedidoRepository.save(pedidoAntigo);
		
		RelatorioDTO relatorioDto = null;

		if (pedidoSalvo.getStatusPedido() == StatusPedido.PRONTO_PRA_ENVIO) {
			relatorioService.gerarRelatorio(pedido.getIdPedido());

			relatorioDto = modelMapper.map(pedidoSalvo, RelatorioDTO.class);
			emailService.enviarEmail("email@email.com", "Cadastro de Perfil",
					relatorioService.prepararEmail(relatorioDto));

			System.out.println(relatorioService.gerarRelatorio(pedido.getIdPedido()));
		}

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
