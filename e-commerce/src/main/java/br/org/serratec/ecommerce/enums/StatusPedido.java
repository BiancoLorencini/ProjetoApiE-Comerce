package br.org.serratec.ecommerce.enums;

public enum StatusPedido {
	ABERTO("Em Aberto"),
	PRONTO_PRA_ENVIO("Pronto para Envio"),
	ENVIADO("Enviado"),
	ENTREGUE("Entregue");

	private String status;
	
	StatusPedido(String valor) {
		this.status = valor;
	}
	
	public String getStatus() {
		return this.status;
	}
	
}