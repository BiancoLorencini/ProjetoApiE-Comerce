package br.org.serratec.ecommerce.records;

import java.util.Set;

public record UserRecord(
		String email,
		String password,
		Set<String> role
		) {
}
