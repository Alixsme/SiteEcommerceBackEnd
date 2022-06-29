package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commande;
import com.intiFormation.entity.Utilisateur;


public interface ICommandeDao extends JpaRepository<Commande, Integer>{

	List<Commande> findByUser(Utilisateur user);

	

	
	
}
