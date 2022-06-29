package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.IProduitDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Message;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IProduitService;


//Importation pour décoder encryptage photo
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Encoder;


@RestController
@RequestMapping("/apiProduit")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

	
	
	
	@Autowired
	IProduitService pService; 

	@Autowired
	ICategorieService cService; 
	
	@Autowired
	ICategorieDao cDao; 
	@Autowired
	IProduitDao pDao; 
	
	public IProduitService getpService() {
		return pService;
	}


	public void setpService(IProduitService pService) {
		this.pService = pService;
	}


	public ICategorieService getcService() {
		return cService;
	}


	public void setcService(ICategorieService cService) {
		this.cService = cService;
	}


	public ICategorieDao getcDao() {
		return cDao;
	}


	public void setcDao(ICategorieDao cDao) {
		this.cDao = cDao;
	}


	public IProduitDao getpDao() {
		return pDao;
	}


	public void setpDao(IProduitDao pDao) {
		this.pDao = pDao;
	}

	
	//afficher tous les Produits
	@GetMapping ("/produits")
	public List <Produit> affichertt()
	{
		List<Produit> liste = pService.getAll();
		return liste;
	}
	
	//Afficher la liste des produits d'une categorie
		@GetMapping ("/produitsParCat/{idCategorie}")
		public List<Produit> prodParCat (@PathVariable ("idCategorie") int idCategorie)
		{
			Categorie categorie = cDao.findByIdCategorie(idCategorie);
			
			List<Produit> liste = pDao.findByCate(categorie);
			
			return liste;
		}
	
	
	//Selection produit par id
	@GetMapping ("/produits/{idProduit}")
	public Optional<Produit> chercherParId (@PathVariable("idProduit") int idProduit)
	{
		Optional<Produit> p = pService.selectByIdProduit(idProduit);
		
		return p;
	}
	
	//Rechercher un produit ds barre de recherche
		@GetMapping ("/SearchProduit/{libProduit}")
		public List<Produit> rechercher (@PathVariable ("libProduit") String libProduit, Model model)
		{
			List <Produit> listeProduit = pService.selectByLibProduit(libProduit);
			return listeProduit;
		}
	
	
	
	
	//Ajouter un produit
	@PostMapping ("/produits") //Avant on utilisait @RequestBody pour le produit, doesn't with multipartfile
	public ResponseEntity<Produit> inserer (@RequestParam ("idCategorie") int idCategorie, @RequestParam ("libProduit") String libProduit,@RequestParam ("quantite") int quantite, @RequestParam ("file") MultipartFile file, HttpSession session) throws IOException
	{
		//PB affiche pas idCategorie apres insertion
		
		String filename = file.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/")+"imageProduit\\"+filename;
		System.out.println(idCategorie);
		Produit p = new Produit();
		
		
		p.setLibProduit(libProduit);
		p.setQuantite(quantite);
		p.setImg("\\imageProduit\\"+filename);
		
		Optional<Categorie> cate =cService.selectByIdCat(idCategorie);
		if (cate.isPresent())
		{
			p.setCate(cate.get());
		}
		
		
		//Pour Doit rajouter les infos du produit ds rubrique form-data (postman) et pas raw
		
		try 
		{
			byte barr[]=file.getBytes(); 
			BufferedOutputStream bout = new BufferedOutputStream (new FileOutputStream(path));
			bout.write(barr);
			bout.flush();
			bout.close();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		p.setImg(file);
		
		
		pService.ajouter(p);
		
		return new ResponseEntity<Produit> (HttpStatus.OK);
		
	}
	
	
	//----------------Smth Weird --------------------------------	
	//Modifier produit 
	//Doit modifier infos dans la parta data form au lieu de raw (indiquer les requestparam qu'on veut changer)
	@PostMapping ("/ModifierProduit") //juste pour dépanner, pb, devrait etre methode Put
	public ResponseEntity<Produit> modifier (@RequestParam("idp") int idProduit, @RequestParam ("idCategorie") int idCategorie, @RequestParam ("libProduit") String libProduit,@RequestParam ("quantite") int quantite, @RequestParam ("file") MultipartFile file, HttpSession session) throws IOException
	{
		String filename = file.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/")+"imageProduit\\"+filename;
		System.out.println(idCategorie);
		Produit p = new Produit();
		
		p.setIdProduit(idProduit);
		p.setLibProduit(libProduit);
		p.setQuantite(quantite);
		p.setImg("\\imageProduit\\"+filename);
		
		Optional<Categorie> cate =cService.selectByIdCat(idCategorie);
		if (cate.isPresent())		{
			p.setCate(cate.get());
		}
		
		
		//Pour Doit rajouter les infos du produit ds rubrique form-data (postman) et pas raw		
		try 
		{
			byte barr[]=file.getBytes(); 
			BufferedOutputStream bout = new BufferedOutputStream (new FileOutputStream(path));
			bout.write(barr);
			bout.flush();
			bout.close();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		p.setImg(file);
		
		
		pService.modifier(p);
		return new ResponseEntity<Produit> (HttpStatus.OK);
	}
	
	
	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file,HttpSession s ) {
		
		
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;  
		//p.setImg("imageproduit\\"+filename);
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	}
		
	}

	
	
	
	//Supprimer un produit
	@DeleteMapping ("/produits/{idProduit}")
	public void supprimer (@PathVariable ("idProduit") int idProduit)
	{
		pService.supprimer(idProduit);
	}
	
	

	/*//Ajouter un produit au panier
	@PostMapping("/ajouterAuPanier/{idProduit}")
	public Message ajouterAuPanier(@PathVariable ("idProduit") int idProduit)
	{
		Optional<Produit> p=pService.selectByIdProduit(idProduit);
		
		if(p.getQuantite()==0)
		
		return new Message("Article ajouté au panier");
	}*/
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
