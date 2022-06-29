package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.LigneCommande;

public interface ILigneCommandeService {

	
	public void ajouter (LigneCommande lc);
	
	public void supprimer (int idLigneCommande);
	
	public void modifier (LigneCommande lc);
	
	
	public List<LigneCommande> affichertt();
	
	public Optional<LigneCommande> afficherLC(int idLigneCommande);
	
	
}
