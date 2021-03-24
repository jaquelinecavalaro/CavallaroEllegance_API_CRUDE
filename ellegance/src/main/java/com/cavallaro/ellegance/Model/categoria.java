package com.cavallaro.ellegance.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //entidade
@Table(name = "db_categoria")//criando tabela
public class categoria {

	//vamos criar nossas colunas agora! não se esqueça das anotações!!
	
	//principal começar com o ID
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //gerar o valor do id automaticamente, auto_increment
	private long id;
	
	//agora, vamos construir o resto das colunas
	@NotNull //obrigo a inserção de dados
	private String nome; //nome das minhas categoria
	
	@NotNull
	private String descricao; //irei descrever os itens que compoem essa categoria
	
	//Categoria é uma tabela de 1 Para N
	/*	@OneToMany(mappedBy = "categoria" , cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List <produto> produto;*/
	
	@OneToMany(mappedBy = "categoria" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List <Material> material;
	
	//agora, vamos construir os gets e sets

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	/*public List<produto> getProduto() {
		return produto;
	}

	public void setProduto(List<produto> produto) {
		this.produto = produto;
	}*/
	
	
	
	
	
}
