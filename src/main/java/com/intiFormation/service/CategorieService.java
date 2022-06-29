package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

@Service
public class CategorieService implements ICategorieService {

	@Autowired
	ICategorieDao cDao; 
	
	//METTRE METHODES PREDEF
	
	public Optional<Categorie> selectByIdCat(int idCategorie)
	{
		Optional <Categorie> op = cDao.findById(idCategorie);
		return op;
	}
	
	public List<Categorie> getAll()
	{
		List <Categorie> liste = cDao.findAll();
		return liste;
	}
	
	public void ajouter(Categorie c)
	{
		cDao.save(c);
	}
	
	public void modifier(Categorie c)
	{
		cDao.save(c);
	}
	
	public void supprimer (int idCategorie)
	{
		cDao.deleteById(idCategorie);
	}
	
	public Optional <Categorie> selectByIdProduit (Produit p)
	{
		Optional<Categorie> liste = cDao.findByProduits(p);
		return liste;
	}

	
	
	
	
	
	public ICategorieDao getcDao() {
		return cDao;
	}

	public void setcDao(ICategorieDao cDao) {
		this.cDao = cDao;
	}
	
	

}
