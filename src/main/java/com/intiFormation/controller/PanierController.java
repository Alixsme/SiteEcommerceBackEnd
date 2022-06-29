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

import com.intiFormation.entity.Panier;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;

@RestController
@RequestMapping("/apiPanier")
@CrossOrigin(origins = "http://localhost:4200")
public class PanierController {

	@Autowired
	IPanierService panierService; 
	
	@Autowired
	IProduitService pService; 
	
	@Autowired
	ILignePanierService lpService; 
	
	
	//Afficher tous les paniers
	
	@GetMapping("/paniers")
	public List<Panier> affichertt()
	{
		List<Panier> liste = panierService.getAll();
		return liste;
	}
	
	
	//Afficher un panier par id
	
	@GetMapping ("/paniers/{idPanier}")
	public Panier afficherPanier (@PathVariable ("idPanier") int idPanier)
	{
		// Does the panier exist
		
		Optional <Panier> opPanier = panierService.getById(idPanier);
		
		Panier p = new Panier();
		
		if (opPanier.isPresent())
		{
			p = opPanier.get();
		}
		
		return p;
	}
	
	
	//Rajouter un panier 
	
	@PostMapping ("/paniers")
	public void ajouterUnPanier (@RequestBody Panier p)
	{
		
		panierService.ajouterPanier(p);
		//session.setAttribute("p", p);
	}
	
	
	
	// Supprimer un panier 
	
	@DeleteMapping ("/paniers/{idPanier}")
	public void supprimer (@PathVariable ("idPanier") int idPanier)
	{
		panierService.supprimer(idPanier);
	}
	
	//Supprimer le panier auto (pour quand on passe la commande)
	
	/*@DeleteMapping ("/paniers")
	public void supprimerAvcCommande (HttpSession session, @RequestBody Panier p)
	{
		session.removeAttribute("p");
	}*/
	
	
	//Modifier un panier 
	
	@PutMapping("/paniers")
	public void modifierPanier (@RequestBody Panier panier, HttpSession session)
	{
		panierService.modifier(panier);
		//session.setAttribute("panier", panier);
	}
	
	
	
	
	
	
	
}
