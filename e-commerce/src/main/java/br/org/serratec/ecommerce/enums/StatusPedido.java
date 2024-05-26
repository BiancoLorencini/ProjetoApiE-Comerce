package br.org.serratec.ecommerce.enums;

public enum StatusPedido {
	ABERTO("A", "aberto", 1),
	PRONTO_PRA_ENVIO("PPE", "pronto pra envio", 2),
	ENVIADO("ENV", "em aberto", 3),
	ENTREGUE("ENT", "entregue", 4);

	private String descricaoTextual;
	private String sigla;
	private int enumerado;

	private StatusPedido(String descricaoTextual, String sigla, int enumerado) {
		this.descricaoTextual = descricaoTextual;
		this.sigla = sigla;
		this.enumerado = enumerado;
	}

	public String getDescricaoTextual() {
		return descricaoTextual;
	}

	public void setDescricaoTextual(String descricaoTextual) {
		this.descricaoTextual = descricaoTextual;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getEnumerado() {
		return enumerado;
	}

	public void setEnumerado(int enumerado) {
		this.enumerado = enumerado;
	}

}