package com.intiFormation.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

public interface ICategorieDao extends JpaRepository<Categorie, Integer>{

	public Optional<Categorie> findByProduits(Produit p); 
	
	public Categorie findByIdCategorie(int idCategorie);

	
	
}
