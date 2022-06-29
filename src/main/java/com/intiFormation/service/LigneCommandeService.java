package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ILigneCommandeDao;
import com.intiFormation.entity.LigneCommande;

@Service
public class LigneCommandeService implements ILigneCommandeService{

	@Autowired
	ILigneCommandeDao lcDao;
	
	
	public void ajouter (LigneCommande lc)
	{
		lcDao.save(lc);
	}
	
	public void supprimer (int idLigneCommande)
	{
		lcDao.deleteById(idLigneCommande);
	}
	
	public void modifier (LigneCommande lc)
	{
		lcDao.save(lc);
	}
	
	
	public List<LigneCommande> affichertt()
	{
		List<LigneCommande> liste =lcDao.findAll();
		return liste;
	}
	
	public Optional<LigneCommande> afficherLC(int idLigneCommande)
	{
		Optional<LigneCommande> opLC = lcDao.findById(idLigneCommande);
		return opLC;
	}
	
	
	

	public ILigneCommandeDao getLcDao() {
		return lcDao;
	}


	public void setLcDao(ILigneCommandeDao lcDao) {
		this.lcDao = lcDao;
	}
	
	
	
	
	
}
