package com.cavallaro.ellegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cavallaro.ellegance.Model.Material;

@Repository
public interface MaterialRepository extends JpaRepository <Material, Long> {

	public List<Material>findAllByNomeContainingIgnoreCase(String nome);
	
	
}
