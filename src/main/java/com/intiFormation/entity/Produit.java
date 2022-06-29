package com.intiFormation.entity;
import java.util.List;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idProduit;
	private String libProduit;
	private String img;
	private int quantite;
	
	@ManyToOne 
	@JoinColumn (name = "idCategorie")
	private Categorie cate;
	
	
	@OneToMany (mappedBy="produit")
	@JsonIgnore
	private List<LigneCommande> lignecommande;
	
	@Transient
	private List <LignePanier> lignepanier;
	
	
	
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(int idProduit, String libProduit, String img, int quantite) {
		super();
		this.idProduit = idProduit;
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
	}
	public Produit(int idProduit2, String libProduit2, String img2, int quantite2, Categorie c) {
		// TODO Auto-generated constructor stub
	}
	public Produit(int idProduit2, String libProduit2, int quantite2) {
		// TODO Auto-generated constructor stub
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibProduit() {
		return libProduit;
	}
	public void setLibProduit(String libProduit) {
		this.libProduit = libProduit;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCate() {
		return cate;
	}
	public void setCate(Categorie cate) {
		this.cate = cate;
	}
	
	public List<LigneCommande> getLignecommande() {
		return lignecommande;
	}
	public void setLignecommande(List<LigneCommande> lignecommande) {
		this.lignecommande = lignecommande;
	}

	
	public List<LignePanier> getLignepanier() {
		return lignepanier;
	}
	public void setLignepanier(List<LignePanier> lignepanier) {
		this.lignepanier = lignepanier;
	}
	public Produit get() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setImg(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
