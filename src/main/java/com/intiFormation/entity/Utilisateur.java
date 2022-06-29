package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Utilisateur {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String username;
	private String password;
	
	private String mail;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="idRole")
	private Role role;
	
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Commande> commande;

	
	
	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String username, String password,
			Role role, List<Commande> commande) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.role = role;
		this.commande = commande;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public List<Commande> getCommande() {
		return commande;
	}


	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String nom2, String prenom2, String dateNaissance2, String username2,
			String mail2, Role role2) {
		this.nom=nom2;
		this.prenom=prenom2;
		this.dateNaissance=dateNaissance2;
		this.username=username2;

		this.mail=mail2;
		this.role=role2;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", username=" + username + ", password=" + password + ", role=" + role + ", commande=" + commande
				+ "]";
	}


	
	
	

	
	
	
	

}
