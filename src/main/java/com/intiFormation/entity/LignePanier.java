package com.intiFormation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LignePanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLignePanier;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.MERGE})
	@JoinColumn(name="idPanier")
	@JsonIgnore
	private Panier panier;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProduit")
	private Produit produit;
	
	private int quantite;
	
	

	public LignePanier(Panier panier2, Produit produit2, int quant) {
		super();
		this.panier = panier2;
		this.produit = produit2;
		this.quantite = quant;
	}
	public LignePanier() {
		// TODO Auto-generated constructor stub
	}
	public int getIdLignePanier() {
		return idLignePanier;
	}
	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
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
