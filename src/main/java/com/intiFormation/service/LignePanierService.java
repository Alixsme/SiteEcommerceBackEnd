package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ILignePanierDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.LignePanier;

@Service
public class LignePanierService implements ILignePanierService{

	@Autowired
	ILignePanierDao lpDao;
	
	public List<LignePanier> getAll()
	{
		List <LignePanier> liste = lpDao.findAll();
		return liste;
	}
	
	public void ajouter(LignePanier lp)
	{
		lpDao.save(lp);
	}
	
	public void modifier(LignePanier lp)
	{
		lpDao.save(lp);
	}
	
	public void supprimer (int idLignePanier)
	{
		lpDao.deleteById(idLignePanier);
	}
	
	public Optional<LignePanier> getById(int idLignePanier)
	{
		Optional<LignePanier> op=lpDao.findById(idLignePanier);
		return op;
	}

	
	
	
	
	
	
	
	
	public ILignePanierDao getLpDao() {
		return lpDao;
	}

	public void setLpDao(ILignePanierDao lpDao) {
		this.lpDao = lpDao;
	}
	
	
	
	
	
	
	
	
}
