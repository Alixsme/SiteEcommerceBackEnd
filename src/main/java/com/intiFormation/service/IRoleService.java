package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Role;

public interface IRoleService {

	public void ajouter (Role r);
	
	
	public Optional<Role> chercherParId(int idRole);
	
	public List<Role> cherchertt();
	
	
	public void supprimer (int idRole);
	
	
	public void modifier (Role r);
	
	
}
