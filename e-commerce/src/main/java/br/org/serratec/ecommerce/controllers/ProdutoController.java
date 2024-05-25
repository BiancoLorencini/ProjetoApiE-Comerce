package br.org.serratec.ecommerce.controllers;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.org.serratec.ecommerce.dtos.ProdutoDTO;
import br.org.serratec.ecommerce.entities.Produto;
import br.org.serratec.ecommerce.services.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/resumido")
	public ResponseEntity<List<ProdutoDTO>> findProdutoDto() {
		return new ResponseEntity<>(produtoService.findProdutoDto(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto produto = produtoService.findById(id);

		if (produto == null) {
			return new ResponseEntity<>(produto, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(produto, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody @Valid Produto produto) {
		return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
	}

	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarProduto(@RequestPart("nome") String nome,
			@RequestParam("valorUnitario") BigDecimal valorUnitario, @RequestPart("imagem") MultipartFile imagem) {
		try {
			produtoService.cadastrarProduto(nome, valorUnitario, imagem);
			return ResponseEntity.ok("Produto cadastrado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Falha ao cadastrar o produto: " + e.getMessage());
		}
	}

//	@PostMapping("/cadastro")
//	public ResponseEntity<String> cadastrarProduto(@RequestParam("nome") String nome,
//			@RequestParam("imagem") MultipartFile imagem) {
//		try {
//			ProdutoDTO produtoDTO = new ProdutoDTO();
//			produtoDTO.setNome(nome);
//			produtoDTO.setImagem(imagem);
//
//			produtoService.cadastrarProduto(produtoDTO);
//			return ResponseEntity.ok("Produto cadastrado com sucesso.");
//		} catch (Exception e) {
//			return ResponseEntity.status(500).body("Falha ao cadastrar o produto: " + e.getMessage());
//		}
//	}

	@PutMapping
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		return new ResponseEntity<>(produtoService.update(produto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProdutoById(@PathVariable Integer id) {
		boolean produtoDeletado = produtoService.deleteProdutoById(id);
		if (produtoDeletado) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
