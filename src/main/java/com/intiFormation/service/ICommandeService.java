package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Commande;
import com.intiFormation.entity.Utilisateur;

public interface ICommandeService {
	
	public void ajouter (Commande commande);
	
	public void supprimer (int idCommande);
	
	public void modifier (Commande commande);
	
	public Optional<Commande> afficherParId(int idCommande);
	
	public List<Commande> affichertt();
	
	public List<Commande> afficherParUtilisateur (Utilisateur user);
	
}
