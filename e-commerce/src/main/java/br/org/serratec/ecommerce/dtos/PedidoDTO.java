package br.org.serratec.ecommerce.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.org.serratec.ecommerce.entities.Cliente;
import br.org.serratec.ecommerce.enums.StatusPedido;

public class PedidoDTO {
	private LocalDate dataPedido;
	private LocalDate dataEnvio;
	private LocalDate dataEntrega;
	private StatusPedido statusPedido;
	private BigDecimal valorTotal;
	private Cliente cliente;

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatus() {
		return statusPedido;
	}

	public void setStatus(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "PedidoDTO [dataPedido=" + dataPedido + ", dataEnvio=" + dataEnvio + ", dataEntrega=" + dataEntrega
				+ ", statusPedido=" + statusPedido + ", valorTotal=" + valorTotal + ", cliente=" + cliente + "]";
	}

}
