package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;

@RestController 
@RequestMapping ("/apiLignePanier")
@CrossOrigin(origins = "http://localhost:4200")
public class LignePanierController {

	@Autowired
	ILignePanierService lpService;
	
	@Autowired
	IPanierService panierService;
	
	@Autowired
	IProduitService pService;
	
	
	// Afficher toutes les lignes de panier
	
	@GetMapping ("/lignesPaniers")
	public List<LignePanier> affichertt()
	{
		List<LignePanier> liste = lpService.getAll();
		return liste;
	}
	
	// Afficher une ligne de panier
	
	@GetMapping ("/lignesPanier/{idLignePanier}")
	public LignePanier afficherLigneParId (@PathVariable("idLignePanier") int idLignePanier)
	{
		Optional<LignePanier> op = lpService.getById(idLignePanier);
		LignePanier lp = new LignePanier();
		
		if(op.isPresent())
		{
			lp=op.get();
		}
		return lp;
	}
	
	
	//Ajouter une ligne de panier ------------------------------ REVOIR METH
	
	@PostMapping ("/lignesPaniers")
	public void ajouterLignePanier (@RequestBody LignePanier lp, @RequestParam("idPanier") int idPanier,@RequestParam("idProduit") int idProduit, @RequestParam("quantite") int quantite)
	{
		//Selection panier si il existe
		Optional<Panier> opPanier = panierService.getById(idPanier);
		
		Panier panier = null; 
		if (opPanier.isPresent())
		{
			panier=opPanier.get();
		}
		
		//selection produit si il existe
		Optional<Produit> opProduit = pService.selectByIdProduit(idProduit);
		
		Produit produit = null; 
		if (opProduit.isPresent())
		{
			produit=opProduit.get();
		}
	
		
		lp.setPanier(panier);
		lp.setProduit(produit);
		lp.setQuantite(quantite);
		lpService.ajouter(lp);
	}
	
	
	
	
	// Supprimer une ligne panier 
	
	@DeleteMapping ("/lignesPaniers/{idLignePanier}")
	public void supprimer (@PathVariable ("idLignePanier") int idLignePanier)
	{
		lpService.supprimer(idLignePanier);
	}
	
	
	
	
	// Modifier une ligne de panier 
	
	@PutMapping ("/lignesPaniers") //pq requestBody marche pas ici
	public void modifier (@RequestBody LignePanier lp, @RequestParam("idProduit") int idProduit, @RequestParam("quantite") int quantite, HttpSession session)
	{
		
		Optional<Produit> opProduit = pService.selectByIdProduit(idProduit);
		
		Produit p = new Produit();
		
		if (opProduit.isPresent())
		{
			p=opProduit.get();
		}
		
		Panier panier = (Panier) session.getAttribute("panier");
		
		lp.setProduit(p);
		lp.setPanier(panier);
		lp.setQuantite(quantite);
		
		lpService.modifier(lp);
	}
	
	
	
	
	
	
	
	
	
	
	
}
