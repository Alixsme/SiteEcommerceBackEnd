package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Panier;

public interface IPanierService {

	public void ajouterPanier (Panier p);
	
	public Optional<Panier> getById(int idPanier);
	
	public List<Panier> getAll();
	
	public void supprimer (int idPanier);
	
	public void modifier (Panier p);
	
}
