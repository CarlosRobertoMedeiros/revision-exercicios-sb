package br.com.roberto.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.roberto.exerciciossb.model.entities.Produto;

public interface ProdutoRepository 
	extends JpaRepository<Produto, Long> {
	
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeContains
	
	//findByNomeStartsWith
	//findByNomeEndsWith
	
	//findByNomeNotContaining
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);

}
