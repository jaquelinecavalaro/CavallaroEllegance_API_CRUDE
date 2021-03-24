package com.cavallaro.ellegance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavallaro.ellegance.Model.categoria;
import com.cavallaro.ellegance.Repository.CategoriaRepository;

//aqui a magia acontece, colocaremos os metodos da forma que queremos achar e o end point que acharmos melhor

@RestController
@RequestMapping ("/categoria") //meu end point
@CrossOrigin ("*") //consigo rodar em qq framework (ver se esta correta essa info)
public class CategoriaController {
	
	//ANTES , vamos instaciar nossa classe do jpa, nosso repository
	@Autowired
	private CategoriaRepository repository;
	
	//agora sim, vamos começar
	@GetMapping //veja, aqui importei minha classe categoria do pac model
	public ResponseEntity <List<categoria>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //coloquei um sistema de busca por id
	public ResponseEntity <categoria>GetById(@PathVariable long id){ //utilizei o pathvariable pois o valor da variável é passada diretamente na URL {}
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity <List<categoria>>GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/descricao/{descricao}") //veja, consigo realizar esse processo aqui, devido ao incremento que coloquei em meu repository
	public ResponseEntity <List <categoria>>GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity <categoria> post (@RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping 
	public ResponseEntity <categoria> put (@RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
