package br.org.serratec.ecommerce.dtos;

import java.math.BigDecimal;
import java.sql.Blob;

import br.org.serratec.ecommerce.entities.Categoria;

@SuppressWarnings("unused")
public class ProdutoDTO {

	private String nome;
	private BigDecimal valorUnitario;
	private byte[] imagem;
	private Categoria categoria;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
