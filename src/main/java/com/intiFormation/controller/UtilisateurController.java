package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IRoleService;
import com.intiFormation.service.IUtilisateurService;

@RestController
@RequestMapping("/apiUtilistateur")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IUtilisateurService uService;
	
	@Autowired
	IRoleService rService;
	
	//Pour encoder me mdp (predef)
	@Autowired 
	BCryptPasswordEncoder bc;
	
	//Ajouter un utilisateur 
	
	@PostMapping("/utilisateurs/{idRole}")
	public void ajouterUtilistaeur(@RequestBody Utilisateur u, @PathVariable ("idRole") int idRole)
	{
		System.out.println("Bonjour");
		
		//recup le role qu'on veut
		Optional<Role> op = rService.chercherParId(idRole);
		Role role = op.get();
		
		//recup le password et l'encode
		String password = u.getPassword();
		password=bc.encode(password);
		
		System.out.println(password);
		
		Utilisateur ut = new Utilisateur (u.getNom(), u.getPrenom(), u.getDateNaissance(), u.getUsername(), u.getMail(), role);
		ut.setPassword(password);
		System.out.println(ut.getNom());
		System.out.println(ut.getUsername());
		System.out.println(ut.getPassword());
		uService.ajouter(ut);

		
	}
	
	
	//Supprimer un utilisateur
	@DeleteMapping("/SupprUtilisateurs/{id}")
	public void supprimerUtilisateur(@PathVariable("id") int id)
	{
		uService.supprimer(id);
	}
	
	
	
	
	@GetMapping("/utilisateurs/{id}")
	public Utilisateur chercherParId(@PathVariable("id") int id){
		Utilisateur u=uService.chercherParId(id).get(); 
		return u; 
	}
	
	@GetMapping("/utilisateursByUsername/{username}")
	public Utilisateur chercherParRole(@PathVariable("username") String username){
		Utilisateur u=uService.chercherParUsername(username); 
		return u; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Se déconnecter (doit quitter la session -> httpsession)
	
	public void deconnexion (HttpSession session)
	{
		session.invalidate();
	}
	
	
	
	
}
