package br.org.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.dtos.ProdutoDTO;
import br.org.serratec.ecommerce.entities.Produto;
import br.org.serratec.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public List<ProdutoDTO> findProdutoDto(){
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> produtosDto = new ArrayList<>();
		
		for(Produto produto : produtos) {
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

	public void deleteProdutoById(Integer id) {
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}
}
