package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur chercherParUsername (String username);
	public Optional<Utilisateur> chercherParId (int id);
	
	public List<Utilisateur> affichertt();
	
	
	public void ajouter (Utilisateur u);
	
	public void supprimer (int id);
	
	public void modifier (Utilisateur u);
}
