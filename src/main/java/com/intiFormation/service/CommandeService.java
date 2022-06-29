package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICommandeDao;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.Utilisateur;

@Service
public class CommandeService implements ICommandeService{

	@Autowired
	ICommandeDao comDao;
	
	public void ajouter (Commande commande)
	{
		comDao.save(commande);
	}

	
	public void supprimer (int idCommande)
	{
		comDao.deleteById(idCommande);
	}
	
	public void modifier (Commande commande)
	{
		comDao.save(commande);
	}
	
	public Optional<Commande> afficherParId(int idCommande)
	{
		Optional<Commande> opCommande = comDao.findById(idCommande);
		return opCommande;
	}
	
	public List<Commande> affichertt()
	{
		List<Commande> liste = comDao.findAll();
		return liste;
	}
	
	
	//Retrouver la commande par un utilisateur 
	public List<Commande> afficherParUtilisateur (Utilisateur user)
	{
		List<Commande> liste=comDao.findByUser(user);
		return liste;
	}
	
	
	
	
	
	
	public ICommandeDao getComDao() {
		return comDao;
	}

	public void setComDao(ICommandeDao comDao) {
		this.comDao = comDao;
	}
	
	
	
	
	
	
}
