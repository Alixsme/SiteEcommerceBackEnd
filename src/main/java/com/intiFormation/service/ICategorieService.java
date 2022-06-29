package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

public interface ICategorieService {

	public Optional<Categorie> selectByIdCat(int idCat);
	
	public List<Categorie> getAll();
	
	public void ajouter(Categorie c);
	
	public void modifier(Categorie c);
	
	public void supprimer (int idCategorie);
	
	public Optional<Categorie> selectByIdProduit (Produit p);
	
}
