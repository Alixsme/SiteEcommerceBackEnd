package com.intiFormation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.intiFormation.jwtConfig.RequestFilter;



@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("us")
	UserDetailsService userDT;
	
	
	
	@Autowired
	private RequestFilter jwtrequestfilter;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDT);
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//			http.csrf().disable().authorizeHttpRequests()
//			.antMatchers("/image/**","/CSS/**").permitAll()  
//			.antMatchers("/gestionAdmin/**").hasAuthority("admin")
//			.antMatchers("/gestionClient/**").hasAuthority("client")
//			.antMatchers("/inscription/**", "/traiterInscription/**").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin().loginPage("/afficherlogin").loginProcessingUrl("/traiterAuth")
//			.successHandler(aus).permitAll()  //
//			.and().logout().permitAll()
//			.and().exceptionHandling().accessDeniedPage("/refuse");
//			
			
			http.csrf().disable()
			.authorizeRequests().antMatchers("/authenticate").permitAll()
			.antMatchers("/imageProduit/**", "/image/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/apiUtilistateur/**").permitAll()
			.anyRequest().authenticated()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
			
				
		}
	
	
	
	
	
	}

	
	
	

