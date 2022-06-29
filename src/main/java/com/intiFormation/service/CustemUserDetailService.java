package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service ("us") //demande à Spring de créer un objet nomme us
public class CustemUserDetailService implements UserDetailsService{

		@Autowired
		IUtilisateurService utilisateurService; 
		
		
		@Override 
		public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
		{
			
			Utilisateur utilisateur = utilisateurService.chercherParUsername(username);
			
			if( utilisateur==null)
			{
				throw new UsernameNotFoundException (username);
			}
			
			List <GrantedAuthority> listeRole = getGrantedAuthority(utilisateur);
			return new User (utilisateur.getUsername(), utilisateur.getPassword(), listeRole);
			
		}
		
		
		private List<GrantedAuthority> getGrantedAuthority(Utilisateur u)	
		{
			List <GrantedAuthority> liste = new ArrayList<>();
			Role role =u.getRole();
			liste.add(new SimpleGrantedAuthority(role.getNom()));
			return liste; 
		}
		
		
		
		
		
		
		
		
}
