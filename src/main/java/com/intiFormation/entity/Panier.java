package com.intiFormation.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Panier {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPanier;
	
	@OneToMany(mappedBy = "panier",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<LignePanier> lignePaniers=new ArrayList<LignePanier>();
	
	
	
	
	
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}
	public void setLignePaniers(List<LignePanier> list) {
		this.lignePaniers = list;
	}
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panier get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
