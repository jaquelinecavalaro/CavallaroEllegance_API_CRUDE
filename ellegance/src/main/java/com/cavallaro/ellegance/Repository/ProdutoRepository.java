package com.cavallaro.ellegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cavallaro.ellegance.Model.produto;

@Repository
public interface ProdutoRepository extends JpaRepository <produto, Long> 
{
	
	
	public List<produto>findAllByNomeContainingIgnoreCase(String nome);
		
	public List<produto>findAllByDescricaoContainingIgnoreCase(String descricao);
}
