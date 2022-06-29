package com.intiFormation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LigneCommande {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idLigneCommande;
	
	@ManyToOne
	@JoinColumn (name="idCommande")
	private Commande commande;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="idProduit")
	private Produit produit;
	
	private int quantite;

	
	
	
	
	
	
	
	public LigneCommande(Commande commande2, Produit produit2, int quantite2) {
		// TODO Auto-generated constructor stub
	}

	public LigneCommande() {
		// TODO Auto-generated constructor stub
	}

	public int getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
