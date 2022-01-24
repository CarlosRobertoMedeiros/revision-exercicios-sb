package br.com.roberto.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.roberto.exerciciossb.model.entities.Produto;

public interface ProdutoRepository 
	extends JpaRepository<Produto, Long> {

}
