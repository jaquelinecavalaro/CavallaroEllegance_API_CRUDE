package com.cavallaro.ellegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cavallaro.ellegance.Model.categoria;

//note, criamos uma INTERFACE para a parte de repository, chamamos o JpaRepository e a classe juntamente com o Long que refere-se ao ID
@Repository //não esquecer das anotações!s
public interface CategoriaRepository extends JpaRepository <categoria, Long> {
//agora criaremos um metodo para que essa categoria repository seja capaz de se comunicar com o banco de dados my sql
	
	public List <categoria>findAllByNomeContainingIgnoreCase(String nome);
	//nome, estamos puxando a lista criada na classe categoria, em seguida falamos, encontre tudo pelo nome e ignore as cases sensitives, ou seja, encontre mesmo que for maiscula ou minuscula
	
	//como quero encontrar as por palavras chaves da descrição, criarei também um metodo para chamar a descrição por palavra chave
	public List <categoria>findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
