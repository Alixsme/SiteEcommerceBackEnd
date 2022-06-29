package com.intiFormation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.dao.IProduitDao;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;
import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.ICommandeService;
import com.intiFormation.service.ILigneCommandeService;
import com.intiFormation.service.ILignePanierService;
import com.intiFormation.service.IPanierService;
import com.intiFormation.service.IProduitService;


@RestController
@RequestMapping("/apiPanierCommande")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
	@Autowired
	IProduitService pService;
	
	@Autowired
	ILigneCommandeService lcService;
	
	@Autowired
	ICommandeService comService;
	
	@Autowired
	IPanierService panierService;
	
	
	@Autowired
	ILignePanierService lpService;
	
	
	

	@RequestMapping ("/gestionClient/Accueil")
	public String afficher()
	{
		return "AccueilClient";
	}
	
	
	//--------------------------------PANIER----------------------------------------------
	
	
	@DeleteMapping ("/supprimerLignePanier")
	public void supprimer (@RequestParam("idLignePanier") int idLignePanier)
	{
		lpService.supprimer(idLignePanier);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/panier")
	public String afficherPanier(HttpSession session)
	{
		//List<LignePanier> listePanier=lpService.getAll();
		//session.setAttribute("listePanier", listePanier);
		return "Panier";
		
	}
	
//	
//	@GetMapping("/panier")
//	public ListPanier afficherPanier ()
//	{
//		Panier panier = panierService.
//		return p;
//	}
//	
	
	
	@RequestMapping ("/ajouterAuPanier")
	public String addToCart (@RequestParam("idProduit") int idProduit, @RequestParam ("quantite") int quant, HttpSession session)
	{
		
		//Recupere le produit
		Produit produit = pService.selectByIdProduit(idProduit).get();
		
		//Recupere le panier
		Panier panier=(Panier)session.getAttribute("panier");
		
		//Instancier lignePanier (pour remplir le panier)
		LignePanier lp = new LignePanier(panier, produit, quant);
		
		
		//Ajouter la ligne de panier au panier
		panier.getLignePaniers().add(lp);
		session.setAttribute("panier", panier); //lp dans panier donc pas besoin de stocker ds session
		
		//Afficher les lignes de panier
		Panier panier2 =(Panier)session.getAttribute("panier");
		
		//Renvoyer les lignes de panier
		List<LignePanier> listelp=panier2.getLignePaniers();
		session.setAttribute("listelp", listelp);
		
		return "Panier";
	}
	
	
	
	
	@RequestMapping ("/supprimerLignePanier2")
	public String supprimer2 (HttpSession session, @RequestParam ("idLignePanier") int idLignePanier)
	{
		
		Panier panier=(Panier)session.getAttribute("panier");
		List<LignePanier> lps = panier.getLignePaniers();
		
		for (int i=0;i<lps.size();i++)
		{
			if (lps.get(i).getIdLignePanier()==idLignePanier)
			{
				panier.getLignePaniers().remove(lps.get(i));
			}
		}

		return ("Panier");
	}
	

	
	
	
	
	
	@RequestMapping("/Modif")
	public String modif(HttpSession session, @RequestParam ("idLignePanier") int idLignePanier,Model model)
	{
		Panier panier=(Panier)session.getAttribute("panier");
//		List<LignePanier> lps = panier.getLignePaniers();
//		LignePanier lp=null;
//		for (int i=0;i<lps.size();i++)
//		{
//			if (lps.get(i).getIdLignePanier()==idLignePanier)
//			{
//			lp=	panier.getLignePaniers().get(i);
//			}
//		}
		
		LignePanier lp=this.getLignePanier(panier, idLignePanier);
		
		
		model.addAttribute("lp", lp);
		
		return "ModifierPanier";
	}
	
	@RequestMapping ("/modifierLignePanier")
	public String modifierLp (@RequestParam ("idLignePanier") int idLignePanier,@RequestParam("quantite") int quantite ,HttpSession session)
	{
		Panier panier=(Panier)session.getAttribute("panier");
	
//		List<LignePanier> ligne = panier.getLignePaniers();
//
//		
//		for (int i=0;i<ligne.size();i++)
//		{
//			if (ligne.get(i).getIdLignePanier()==idLignePanier)
//			{
//				panier.getLignePaniers().get(i).setQuantite(quantite);
//			}
//		}
		
		LignePanier lp = this.getLignePanier(panier, idLignePanier);
		lp.setQuantite(quantite);
		
		return "redirect:/gestionClient/panier";
	}
	

	//Méthode pour recup la ligne de panier (pour éviter de trop répéter le code)
	private LignePanier getLignePanier (Panier panier, int idLignePanier)
	{
		List<LignePanier> lps = panier.getLignePaniers();
		for (int i=0;i<lps.size();i++)
		{
			if (lps.get(i).getIdLignePanier()==idLignePanier)
			{
			return panier.getLignePaniers().get(i);
			}
			
		}
		return null;
	}
	
	
	//--------------------------------COMMANDE----------------------------------------------
	
	//FAIRE PAGE JSP pour les commandes
	
	
	//Rajouter condition authentification
	
	@RequestMapping ("/creerLigneCommande")
	public String crea (HttpSession session, Model model)
	{
		LocalDate date = LocalDate.now();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		Commande commande = new Commande(date, user);
		
		comService.ajouter(commande);
		
		Panier panier=(Panier) session.getAttribute("panier");
		List<LignePanier> lps = panier.getLignePaniers();
		
		
		List <LigneCommande> lc = new ArrayList<>();
		
		for (int i=0;i<lps.size();i++)
		{
			LignePanier lp = lps.get(i);
			
			LigneCommande ligneCommande = new LigneCommande(commande, lp.getProduit(), lp.getQuantite());
			System.out.println(lp.getQuantite());
			lcService.ajouter(ligneCommande);
			//ligneCommandes.add(ligneCommande);
			
			//décrémenter la quantite du produit 
			Produit nouveauProduit = lps.get(0).getProduit();
			nouveauProduit.setQuantite(nouveauProduit.getQuantite()-lps.get(0).getQuantite());
			pService.modifier(nouveauProduit);
		}
		
		commande.setLigneCommandes(lc);
		comService.ajouter(commande);
		model.addAttribute("c", commande);
		
		//Doit supprimer le panier une fois la commande passée
		session.removeAttribute("panier");
		
		//lcService.ajouter(ligneCommandes);
		
		return "redirect:/gestionClient/Accueil";
		
		
		//LigneCommande à moitie enregistree ds BD ?
		//Mauvaise redirection vers accueil
	}
	
	
	@RequestMapping("/validerCommande")
	public String valider (HttpSession session)
	{
		if (session.getAttribute("commande")==null)
		{
			//Creer nouvelle commande avec date 
			LocalDate date = LocalDate.now();
			Commande commande=new Commande(date);
			
			//Faire lien entre utilisateur et la commande
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			commande.setUser(user);
			
			//Ajouter la commande (meth ajout dans comService)
			comService.ajouter(commande);
			
			//Recup panier + ligne panier
			Panier panier=(Panier) session.getAttribute("panier");
			List<LignePanier> lps = panier.getLignePaniers();
			
			//Afficher ? pourquoi ?
			List<LigneCommande> ligneCommandes = new ArrayList<>();
			
			//Faire une nouvelle ligne de commande
			LigneCommande lc = new LigneCommande();
			
			for (LignePanier lignePanier :  panier.getLignePaniers())
			{
				
				
				/*lc = new LigneCommande(commande, lignePanier.getProduit(), lignePanier.getQuantite());
				ligneCommande.add(lc);
				lcService.ajouter(ligneCommande);
				
				Produit newProduit = lps.get(0).getProduit();
				newProduit.setQuantite(newProduit.getQuantite()-lignePanier.);*/
				
				
			}
			
			
			
		}
		
		return "/gestionClient/Accueil";
	}
	
	
	
	
	
}
