package br.org.serratec.ecommerce.dtos;

public class ClienteDTO {

	private String nomeCompleto;
	private String telefone;
	private String email;
//	private PedidoDTO pedidos;
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
//	public PedidoDTO getPedidos() {
//		return pedidos;
//	}
//	public void setPedidos(PedidoDTO pedidos) {
//		this.pedidos = pedidos;
//	}
	@Override
	public String toString() {
		return "ClienteDTO [nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + ", email=" + email + "]";
	}

	
	
}
