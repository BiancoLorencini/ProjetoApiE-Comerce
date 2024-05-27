package br.org.serratec.ecommerce.converter;

import br.org.serratec.ecommerce.enums.StatusPedido;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusPedidoConverter implements AttributeConverter<StatusPedido, String> {

	@Override
	public String convertToDatabaseColumn(StatusPedido attribute) {
		return attribute.getStatus();
	}

	@Override
	public StatusPedido convertToEntityAttribute(String statusPedido) {
		if(statusPedido == null) {
			return null;
		}
		for(StatusPedido status : StatusPedido.values()) {
			if(status.getStatus().equals(statusPedido)) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("O Status " + statusPedido + " não é um status válido.");
	}
	
}
