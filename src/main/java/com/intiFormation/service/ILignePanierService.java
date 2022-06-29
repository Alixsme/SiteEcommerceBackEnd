package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.LignePanier;

public interface ILignePanierService {

	public List<LignePanier> getAll();
	
	public void ajouter(LignePanier lp);
	
	public void modifier(LignePanier lp);
	
	public void supprimer (int idLignePanier);
	public Optional<LignePanier> getById(int idLignePanier);
	
}
