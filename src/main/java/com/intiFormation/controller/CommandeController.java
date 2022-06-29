package com.intiFormation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;
import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.ICommandeService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;
import com.intiFormation.service.IUtilisateurService;

@RestController
@RequestMapping ("/apiCommande")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController {

	@Autowired
	IProduitService pService;
	
	@Autowired 
	ICommandeService comService;
	
	@Autowired 
	IPanierService panierService;
	
	@Autowired 
	IUtilisateurService uSerivce;
	
	
	//Afficher toutes les commande 
	@GetMapping("/commandes")
	public List<Commande> getAll()
	{
		List<Commande> liste = comService.affichertt();
		return liste;
	}
	
	//Afficher Une commande par idCommande
	@GetMapping ("/commandes/{idCommande}")
	public Optional <Commande> afficherComParId (@PathVariable ("idCommande") int idCommande)
	{
		Optional<Commande> opCom=comService.afficherParId(idCommande);
//		
//		Commande commande = new Commande (idCommande);
//		
//		if (opCom.isPresent())
//		{
//			commande = opCom.get();
//		}
		
		return opCom;
	}
	
	
	//Trouver une commande par utilisateur (need username)
	@GetMapping ("/commandes/{username}")
	public List<Commande> afficherParUtilisateur (@PathVariable ("username") String username, HttpSession session)
	{
		Utilisateur user =(Utilisateur) session.getAttribute("user");
		List<Commande> liste = comService.afficherParUtilisateur(user);
		return liste;
	}
	
	
	//---------------------PAS SUR----------------------
	
	// Ajouter commande 
	@PostMapping ("/commandes")
	public void ajouterCommande (@RequestBody Commande commande, HttpSession session)
	{
		//Faire une commande avec la date du moment
		LocalDate date = LocalDate.now();
		
		//Formater la date pour pas avoir de pb 
		String formaterLaDate = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		commande.setDateCommande(formaterLaDate);
		
		//recupérer l'utilisateur de la session 
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		commande.setUser(user);
		
		//Ajouter la commande
		comService.ajouter(commande);
		
		//Mettre la commande dans la session 
		session.setAttribute("commande", commande);
		
	}
	
//	@RequestMapping("/validerCommande")
//	public String valider (HttpSession session)
//	{
//		if (session.getAttribute("commande")==null)
//		{
//			//Creer nouvelle commande avec date 
//			LocalDate date = LocalDate.now();
//			Commande commande=new Commande(date);
//			
//			//Faire lien entre utilisateur et la commande
//			Utilisateur user = (Utilisateur) session.getAttribute("user");
//			commande.setUser(user);
//			
//			//Ajouter la commande (meth ajout dans comService)
//			comService.ajouter(commande);
//			
//			//Recup panier + ligne panier
//			Panier panier=(Panier) session.getAttribute("panier");
//			List<LignePanier> lps = panier.getLignePaniers();
//			
//			//Afficher ? pourquoi ?
//			List<LigneCommande> ligneCommandes = new ArrayList<>();
//			
//			//Faire une nouvelle ligne de commande
//			LigneCommande lc = new LigneCommande();
//			
//			for (LignePanier lignePanier :  panier.getLignePaniers())
//			{
//				
//				
//				/*lc = new LigneCommande(commande, lignePanier.getProduit(), lignePanier.getQuantite());
//				ligneCommande.add(lc);
//				lcService.ajouter(ligneCommande);
//				
//				Produit newProduit = lps.get(0).getProduit();
//				newProduit.setQuantite(newProduit.getQuantite()-lignePanier.);*/
//
//			}
//		}
//		
//		return "/gestionClient/Accueil";
//	}
	
	
	
	// Supprimer commande 
	@DeleteMapping ("/commandes/{idCommande}")
	public void supprimer (@PathVariable("idCommande") int idCommande)
	{
		comService.supprimer(idCommande);
	}
	
	
	
	//Modifier commande 
	@PutMapping ("/commandes")
	public void modifierCommande (@RequestBody Commande commande)
	{
		comService.modifier(commande);
	}
	
}
