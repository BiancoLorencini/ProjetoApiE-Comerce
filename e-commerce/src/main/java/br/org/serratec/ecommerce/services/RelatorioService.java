package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.dtos.ItemPedidoDTO;
import br.org.serratec.ecommerce.dtos.RelatorioDTO;
import br.org.serratec.ecommerce.entities.ItemPedido;
import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.entities.Produto;
import br.org.serratec.ecommerce.repositories.ItemPedidoRepository;
import br.org.serratec.ecommerce.repositories.PedidoRepository;
import br.org.serratec.ecommerce.repositories.ProdutoRepository;

@Service
public class RelatorioService {
	@Autowired
	RelatorioDTO relatorioDto;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
		
	
	
	
	
	public RelatorioDTO gerarRelatorio(Integer idPedido) {
	    Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);

	    if (pedidoOptional.isEmpty()) {
	        return null;
	    }

	    Pedido pedido = pedidoOptional.get();
	    
	    List<ItemPedido> itens = itemPedidoRepository.findByPedidoIdPedido(pedido.getIdPedido());
	    List<ItemPedidoDTO> itensRelatorio = new ArrayList<>();
	    RelatorioDTO relatorio = new RelatorioDTO();

	    relatorio.setIdPedido(pedido.getIdPedido());
	    relatorio.setDataPedido(pedido.getDataPedido());
	    relatorio.setValorTotal(pedido.getValorTotal());
 
	    for (ItemPedido item : itens) {
	        ItemPedidoDTO itemDTO = new ItemPedidoDTO();
	        Produto produto = item.getProduto();
	        
	        itemDTO.setIdProduto(produto.getIdProduto());
	        itemDTO.setNomeProduto(produto.getNome());
	        itemDTO.setPrecoVenda(item.getPrecoVenda());
	        itemDTO.setQuantidade(item.getQuantidade());
	        itemDTO.setValorBruto(item.getValorBruto());
	        itemDTO.setPercentualDesconto(item.getPercentualDesconto());
	        itemDTO.setValorLiquido(item.getValorLiquido());
	        
	        itensRelatorio.add(itemDTO);
	    }

	    relatorio.setItens(itensRelatorio);

	    return relatorio;
	}
}
