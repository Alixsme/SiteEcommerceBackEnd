package com.intiFormation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idRole;
	
	private String nom; 
	private String librole;
	private String description;
	
	@OneToMany (mappedBy = "role")
	@JsonIgnore
	private List<Utilisateur> utilisateurs;
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int idRole, String librole, String description) {
		super();
		this.idRole = idRole;
		this.librole = librole;
		this.description = description;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getLibrole() {
		return librole;
	}
	public void setLibrole(String librole) {
		this.librole = librole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
