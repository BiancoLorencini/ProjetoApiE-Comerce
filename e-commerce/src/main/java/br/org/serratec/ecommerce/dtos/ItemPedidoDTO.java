package br.org.serratec.ecommerce.dtos;

import java.math.BigDecimal;

import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.entities.Produto;

public class ItemPedidoDTO {
	private Integer idProduto;
	private String nomeProduto;
	private BigDecimal precoVenda;
	private Integer quantidade;
	private BigDecimal valorBruto;
	private BigDecimal percentualDesconto;
	private BigDecimal valorLiquido;
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}
	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	@Override
	public String toString() {
		return "ItemPedidoDTO [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", precoVenda=" + precoVenda
				+ ", quantidade=" + quantidade + ", valorBruto=" + valorBruto + ", percentualDesconto="
				+ percentualDesconto + ", valorLiquido=" + valorLiquido + "]";
	}

}

