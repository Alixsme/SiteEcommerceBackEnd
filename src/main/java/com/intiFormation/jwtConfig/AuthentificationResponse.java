package com.intiFormation.jwtConfig;

import org.springframework.web.bind.annotation.RequestMapping;

public class AuthentificationResponse {
	
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthentificationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	
	
	
	

}
