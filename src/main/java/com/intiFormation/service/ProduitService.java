package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IProduitDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

@Service
public class ProduitService implements IProduitService{

	@Autowired
	IProduitDao pDao; 
	

	
	public void ajouter (Produit p)
	{
		pDao.save(p);
	}
	
	public void modifier(Produit p)
	{
		pDao.save(p);
	}
	
	public void supprimer(int idProduit)
	{
		pDao.deleteById(idProduit);
	}
	
	public List<Produit> getAll()
	{
		List<Produit> liste = pDao.findAll();
		return liste;
	}
	
	public Optional<Produit> selectByIdProduit(int idProduit)
	{
		Optional<Produit> op = pDao.findById(idProduit);
		return op;
	}
	
	public List <Produit> selectByIdCategorie (Categorie c)
	{
		List<Produit> liste = pDao.findByCate(c);
		return liste;
	}
	
	public List<Produit> selectByLibProduit(String libProduit)
	{
		List<Produit> op = pDao.findByLibProduit (libProduit);
		return op;
	}

	
	
	
	
	
	public IProduitDao getpDao() {
		return pDao;
	}

	public void setpDao(IProduitDao pDao) {
		this.pDao = pDao;
	}
	
	
	

	
	
	
	
	
}
