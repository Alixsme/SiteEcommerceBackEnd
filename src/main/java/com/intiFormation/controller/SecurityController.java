package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.intiFormation.entity.Utilisateur;
import com.intiFormation.jwtConfig.AuthentificationRequest;
import com.intiFormation.jwtConfig.AuthentificationResponse;
import com.intiFormation.jwtConfig.jwtUtil;
import com.intiFormation.service.CustemUserDetailService;
import com.intiFormation.service.IUtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {

	@Autowired
	IUtilisateurService uService; 
	
	@Autowired
	BCryptPasswordEncoder bc; 
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private CustemUserDetailService custemUserDetailsService;
	
	
	@Autowired
	private jwtUtil jwtokenUtil;
	
	

//	@RequestMapping ("afficherlogin")
//	public String afficherForm()
//	{
//		
//		
//		return "PageAuthentification";
//	}
//	
//	@RequestMapping ("/refuse")
//	public String refuse()
//	{
//		return("refuse");
//	}
//	
//	@RequestMapping ("/inscription")
//	public String inscription (Model model)
//	{
//		Utilisateur u = new Utilisateur();
//		model.addAttribute("u", u);
//		return "inscription";
//	}
//	
//	@RequestMapping ("/traiterInscription")
//	public String ajouter (@ModelAttribute ("u") Utilisateur u, @RequestParam ("password") String password)
//	{
//		u.setPassword(bc.encode(password));
//		uService.ajouter(u);
//		return "redirect:/afficherlogin";
//	}
//	
	
	@GetMapping("/test22")
	public String test22()
	{
		return "Bonjour";
	}
	
	@RequestMapping(value="/authenticate" ,method =RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		
		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}
	
	
	
	
	
	
}
