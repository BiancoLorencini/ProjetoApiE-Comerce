package br.org.serratec.ecommerce.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RelatorioDTO {
	private Integer idPedido;
	private LocalDate dataPedido;
	private BigDecimal valorTotal;
	private List<ItemPedidoDTO> itens;
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<ItemPedidoDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}
	@Override
	public String toString() {
		return  String.format(
				"""
				===================
				RELATÓRIO DO PEDIDO
				===================
				
				Código do Pedido: %s
				Data do Pedido: %s
				Valor Total: R$%s
				
				PRODUTOS:
				%s
				
				"""
				
				, idPedido, dataPedido, valorTotal, itens.toString() );
	}
	

}
