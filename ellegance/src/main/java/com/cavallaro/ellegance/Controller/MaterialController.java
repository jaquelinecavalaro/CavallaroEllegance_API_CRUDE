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

import com.cavallaro.ellegance.Model.Material;
import com.cavallaro.ellegance.Repository.MaterialRepository;

@RestController
@RequestMapping("/material")
@CrossOrigin("*")
public class MaterialController {

	@Autowired
	private MaterialRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Material>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Material>GetById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity <List<Material>>GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity <Material> post (@RequestBody Material categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping 
	public ResponseEntity <Material> put (@RequestBody Material categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delet(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
