package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

public interface IProduitService {

	public void ajouter (Produit p);
	
	public void modifier(Produit p);
	
	public void supprimer(int idProduit);
	
	public List<Produit> getAll();
	
	public Optional<Produit> selectByIdProduit(int idProduit);
	
	public List <Produit> selectByIdCategorie (Categorie c);
	
	
	public List<Produit> selectByLibProduit(String libProduit);
	
}
