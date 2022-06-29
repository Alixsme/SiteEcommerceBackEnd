package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IRoleDao;
import com.intiFormation.entity.Role;

@Service
public class RoleService implements IRoleService{
	
	
	@Autowired
	IRoleDao rDao;
	
	
	public void ajouter (Role r)
	{
		rDao.save(r);
	}
	
	
	public Optional<Role> chercherParId(int idRole)
	{
		Optional<Role> op=rDao.findById(idRole);
		return op;
	}
	
	public List<Role> cherchertt()
	{
		List<Role> liste=rDao.findAll();
		return liste;
	}
	
	
	public void supprimer (int idRole)
	{
		rDao.deleteById(idRole);
	}
	
	
	public void modifier (Role r)
	{
		rDao.save(r);
	}


	
	
	public IRoleDao getrDao() {
		return rDao;
	}


	public void setrDao(IRoleDao rDao) {
		this.rDao = rDao;
	}
	
	
	
	

}
