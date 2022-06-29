package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IUtilisateurDao;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	IUtilisateurDao utilisateurDao; 
	
	
	
	public Utilisateur chercherParUsername (String username)
	{
		return utilisateurDao.findByUsername(username);
	}
	
	public Optional<Utilisateur> chercherParId (int id)
	{
		Optional<Utilisateur> op=utilisateurDao.findById(id);
		return op;
	}
	
	public List<Utilisateur> affichertt()
	{
		List<Utilisateur> liste = utilisateurDao.findAll();
		return liste;
	}
	
	
	
	public void ajouter (Utilisateur u)
	{
		utilisateurDao.save(u);
	} 
	
	public void supprimer (int id)
	{
		utilisateurDao.deleteById(id);
	}
	
	public void modifier (Utilisateur u)
	{
		utilisateurDao.save(u);
	}

	
	
	
	public IUtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
	
	
	
	
	
}
