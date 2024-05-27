package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.dtos.RelatorioDTO;
import br.org.serratec.ecommerce.entities.ItemPedido;
import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.entities.Produto;
import br.org.serratec.ecommerce.repositories.ItemPedidoRepository;
import br.org.serratec.ecommerce.repositories.PedidoRepository;
import br.org.serratec.ecommerce.repositories.ProdutoRepository;

@Service
public class RelatorioDtoService {
	@Autowired
	RelatorioDTO relatorioDto;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
		
	
	public List<RelatorioDTO> gerarRelatorio() {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<Produto> produtos = produtoRepository.findAll();
		List<ItemPedido> itens = itemPedidoRepository.findAll();
		
		List<RelatorioDTO> relatoriosDto = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			RelatorioDTO relatorioDto = new RelatorioDTO();
			relatorioDto.setIdPedido(pedido.getIdPedido());
			relatorioDto.setDataPedido(pedido.getDataPedido());
			relatorioDto.setValorTotal(pedido.getValorTotal());
			
			relatoriosDto.add(relatorioDto);
			
			for(Produto produto : produtos) {
				
				relatorioDto.setIdProduto(produto.getIdProduto());
				relatorioDto.setNomeProduto(produto.getNome());
				
				relatoriosDto.add(relatorioDto);
				
				for(ItemPedido item : itens) {
					
					relatorioDto.setPrecoVenda(item.getPrecoVenda());
					relatorioDto.setQuantidade(item.getQuantidade());
					relatorioDto.setValorBruto(item.getValorBruto());
					relatorioDto.setPercentualDesconto(item.getPercentualDesconto());
					relatorioDto.setValorLiquido(item.getValorLiquido());
					
					relatoriosDto.add(relatorioDto);
				}
			}
			
			
		}
		
			
		return relatoriosDto;
		

	}
}
