package br.org.serratec.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {
	@GetMapping("/health-check")
	public ResponseEntity<Object> healthCheck() {
		return ResponseEntity.status(200).body("Health Checked!");
	}
	@GetMapping("/health-check-authentication")
    public ResponseEntity<Object> healthCheckAuthentication() {
        return ResponseEntity.status(200).body("Health Authentication Checked!");
    }
}
