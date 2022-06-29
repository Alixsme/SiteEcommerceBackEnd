package com.intiFormation.entity;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCommande;
	private LocalDate dateCommande;
	
	@ManyToOne
	@JoinColumn (name="idUser")
	@JsonIgnore
	private Utilisateur user;
	
	
	@OneToMany (mappedBy = "commande", cascade=CascadeType.PERSIST)
	@JsonIgnore
	private List<LigneCommande> ligneCommandes;

	
	
	
	public Commande(LocalDate dateCommande, Utilisateur user) {
		super();
		this.dateCommande = dateCommande;
		this.user = user;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(LocalDate date) {
		// TODO Auto-generated constructor stub
	}

	public Commande(int idCommande2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(ArrayList<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public void setLigneCommandes(LigneCommande ligneCommande) {
		// TODO Auto-generated method stub
		
	}

	public void setLigneCommandes(List<LigneCommande> listCommandes) {
		// TODO Auto-generated method stub
		
	}

	public void setDateCommande(String formaterLaDate) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
