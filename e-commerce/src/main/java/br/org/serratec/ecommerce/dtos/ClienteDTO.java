package br.org.serratec.ecommerce.dtos;

import java.util.List;

import br.org.serratec.ecommerce.entities.Pedido;

public class ClienteDTO {

	private String nomeCompleto;
	private String telefone;
	private String email;
	private List<Pedido> pedidos;

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return "ClienteDTO [nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	
	
}
