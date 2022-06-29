package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;




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

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IProduitService;



@RestController
@RequestMapping("/apiCategorie")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

	@Autowired
	ICategorieService cService; 
	@Autowired
	IProduitService pService; 
	
	
	
	//afficher toutes les categories
	@GetMapping ("/categories")
	public List <Categorie> affichertt()
	{
		List<Categorie> liste = cService.getAll();
		return liste;
	}
	
	//Selection cat par idcat
	@GetMapping ("/categories/{idCategorie}")
	public Optional<Categorie> chercherParId (@PathVariable("idCategorie") int idCategorie)
	{
		Optional<Categorie> c = cService.selectByIdCat(idCategorie);
		
		return c;
	}
	//Selection cat par idPro
		@GetMapping ("/categoriesParProduit")
		public Optional<Categorie> chercherParIdProd (@RequestBody Produit p)
		{
			Optional<Categorie> c = cService.selectByIdProduit(p);
			
			return c;
		}
	
	
	//Ajouter une categorie
	@PostMapping ("/categories")
	public void inserer (@RequestBody Categorie c)
	{
		cService.ajouter(c);
	}
	
	//Modifier Categorie
	@PutMapping ("/categories")
	public void modifier (@RequestBody Categorie c)
	{
		cService.modifier(c);
	}
	
	//Supprimer une categorie
	@DeleteMapping ("/categories/{idCategorie}")
	public void supprimer (@PathVariable ("idCategorie") int idCategorie)
	{
		cService.supprimer(idCategorie);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
