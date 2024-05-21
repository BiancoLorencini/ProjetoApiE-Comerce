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

import br.org.serratec.ecommerce.entities.Categoria;
import br.org.serratec.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);

		if (categoria == null) {
			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.update(categoria), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable Integer id) {
		categoriaService.deleteCategoriaById(id);
	}
}
