package com.intiFormation.controller;

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
import com.intiFormation.entity.Panier;
import com.intiFormation.service.ICommandeService;
import com.intiFormation.service.ILigneCommandeService;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;

@RestController
@RequestMapping("/apiLigneCommande")
@CrossOrigin(origins = "http://localhost:4200")
public class LigneCommandeController {

	@Autowired
	ILigneCommandeService lcService;
	
	@Autowired
	ICommandeService cService;
	
	@Autowired
	ILignePanierService lpService; 
	
	@Autowired
	IPanierService panierService; 
	
	@Autowired
	IProduitService pService; 
	
	
	//Afficher toutes les lignes de commande 
	
	@GetMapping ("/ligneCommandes")
	public List<LigneCommande> affichertt()
	{
		List<LigneCommande> liste = lcService.affichertt();
		return liste; 
	}
	
	//Afficher Une ligne de commande par id 
	@GetMapping("/ligneCommandes/{idLigneCommande}")
	public Optional<LigneCommande> afficher (@PathVariable("idLigneCommande") int idLigneCommande)
	{
		Optional<LigneCommande> opLC = lcService.afficherLC(idLigneCommande);
		return opLC;
	}
	
	
	//Ajouter ligne commande (à la session) ---------------------not sure------------
	
	@PostMapping("/ligneCommandes")
	public void ajouterLigneCommande (@RequestBody LigneCommande lc, HttpSession session)
	{
		//Recuperer Panier de la session 
		Panier panier = (Panier) session.getAttribute("panier");
		
		//Recupere la commande de la session 
		Commande commande = (Commande) session.getAttribute("commande");
		
		for (int i=0;i<panier.getLignePaniers().size();i++)
		{
			//Ajoute le produit
			lc.setProduit(panier.getLignePaniers().get(i).getProduit());
			
			//Ajoute la quantite
			lc.setQuantite(panier.getLignePaniers().get(i).getQuantite());
			
			//decremente la quantite + modif le produit
			lc.getProduit().setQuantite(lc.getProduit().getQuantite()-lc.getQuantite());
			
			pService.ajouter(lc.getProduit());
			
			lc.setCommande(commande);
			
		}
		
		
		lcService.ajouter(lc);
	}
	
	
	
	//Supprimer ligne commande
	@DeleteMapping ("/ligneCommandes/{idLigneCommande}")
	public void supprimerCommande (@PathVariable ("idLigneCommande") int idLigneCommande)
	{
		lcService.supprimer(idLigneCommande);
	}
	
	
	
	//Modifier ligne commande
	
	@PutMapping ("/ligneCommandes")
	public void modifier (@RequestBody LigneCommande lc)
	{
		lcService.modifier(lc);
	}
	
	
	
}
