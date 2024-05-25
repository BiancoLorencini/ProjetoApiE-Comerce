package br.org.serratec.ecommerce.enums;

public enum Status {
	FINALIZADO("F", "finalizado", 1), PROCESSANDO("P", "processando", 2);

	private String descricaoTextual;
	private String sigla;
	private int enumerado;

	private Status(String descricaoTextual, String sigla, int enumerado) {
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