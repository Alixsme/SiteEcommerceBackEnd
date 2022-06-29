package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IPanierDao;
import com.intiFormation.entity.Panier;

@Service
public class PanierService implements IPanierService {

	@Autowired
	IPanierDao panierDao;
	
	
	public void ajouterPanier (Panier p)
	{
		panierDao.save(p);
	}
	
	public Optional<Panier> getById(int idPanier)
	{
		Optional<Panier> op = panierDao.findById(idPanier); 
		return op;
	}
	
	public List<Panier> getAll()
	{
		List<Panier> liste = panierDao.findAll();
		return liste; 
	}
	
	public void supprimer (int idPanier)
	{
		panierDao.deleteById(idPanier);
	}
	
	public void modifier (Panier p)
	{
		panierDao.save(p);
	}

	public IPanierDao getPanierDao() {
		return panierDao;
	}

	public void setPanierDao(IPanierDao panierDao) {
		this.panierDao = panierDao;
	}
	
	
	
	
	
}

    