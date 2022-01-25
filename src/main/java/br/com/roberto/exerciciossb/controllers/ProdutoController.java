package br.com.roberto.exerciciossb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.exerciciossb.model.entities.Produto;
import br.com.roberto.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
//	@PostMapping
//	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}
	
	//Uma alternativa ao post e put, porém não gosto da abordagem
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping
	public List<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutosPorPagina(
			@PathVariable int numeroPagina,
			@PathVariable int qtdePagina){
		if (qtdePagina >=20) qtdePagina = 20;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return produtoRepository.findAll(page);
		
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@GetMapping(path="/search/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNomeViaJPQL(@PathVariable String parteNome) {
		return produtoRepository.searchByNameLike(parteNome);
	}
	
	
	//Com PathVariable
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable Long id) {
		return produtoRepository.findById(id);
	}
	
//	@PutMapping
//	public Produto alterarProduto(@Valid Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	

	

}
