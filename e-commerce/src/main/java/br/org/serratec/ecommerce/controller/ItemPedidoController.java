package br.org.serratec.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ecommerce.entities.ItemPedido;
import br.org.serratec.ecommerce.services.ItemPedidoService;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

	@Autowired
	ItemPedidoService itemPedidoService;

	@GetMapping
	public ResponseEntity<List<ItemPedido>> findAll() {
		return new ResponseEntity<>(itemPedidoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> findById(@PathVariable Integer id) {
		ItemPedido itemPedido = itemPedidoService.findById(id);

		if (itemPedido == null)
			return new ResponseEntity<>(itemPedido, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(itemPedido, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ItemPedido> save(@RequestBody ItemPedido itemPedido) {
		return new ResponseEntity<>(itemPedidoService.save(itemPedido), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<ItemPedido> update(@RequestBody ItemPedido itemPedido) {
		return new ResponseEntity<>(itemPedidoService.update(itemPedido), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemPedido> delete(@PathVariable Integer id) {
		Boolean deletado = itemPedidoService.delete(id);

		if (deletado) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
