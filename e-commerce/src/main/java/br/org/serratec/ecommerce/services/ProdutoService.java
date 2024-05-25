package br.org.serratec.ecommerce.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.org.serratec.ecommerce.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.org.serratec.ecommerce.dtos.ProdutoDTO;
import br.org.serratec.ecommerce.entities.Produto;
import br.org.serratec.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public List<ProdutoDTO> findProdutoDto() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> produtosDto = new ArrayList<>();

		for (Produto produto : produtos) {
			ProdutoDTO produtoDto = new ProdutoDTO();
			produtoDto.setNome(produto.getNome());
			produtoDto.setValorUnitario(produto.getValorUnitario());
			produtoDto.setImagem(produto.getImagem());
			produtoDto.setCategoria(produto.getCategoria());

			produtosDto.add(produtoDto);
		}
		return produtosDto;
	}

	public Produto findById(Integer id) {
		return produtoRepository.findById(id).get();
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	public boolean deleteProdutoById(Integer id) {
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			Produto produtoDeletado = produtoRepository.findById(id).orElse(null);
			if (produtoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void cadastrarProduto(String nome,BigDecimal valorUnitario, MultipartFile imagem) throws IOException {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setNome(nome);
		produtoDTO.setValorUnitario(valorUnitario);
		produtoDTO.setImagem(imagem.getBytes());

		Produto produto = new Produto();

		produto.setNome(produtoDTO.getNome());
		produto.setValorUnitario(produtoDTO.getValorUnitario());

		if (imagem != null && !imagem.isEmpty()) {
			produto.setImagem(imagem.getBytes());
		}

		produtoRepository.save(produto);
	}

//	public void cadastrarProduto(ProdutoDTO produtoDTO) throws IOException {
//		Produto produto = new Produto();
//		produto.setNome(produtoDTO.getNome());
//		produto.setImagem(produtoDTO.getImagem());
//
//		produtoRepository.save(produto);
//	}

}
