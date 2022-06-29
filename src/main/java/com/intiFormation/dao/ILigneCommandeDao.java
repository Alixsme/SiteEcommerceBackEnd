package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.LigneCommande;


public interface ILigneCommandeDao extends JpaRepository<LigneCommande, Integer>{

	
	
}
