package com.abhishek.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abhishek.app.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	//Approach 1:Following method will take username and password  from .properties.
	//we should declared username and password in .properties file if we use below approach.
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}*/
	
	
	//******************************************************************
	//Approach 2:
	
	@Autowired
	private AuthenticationEntryPoint entryPoint;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("AuthenticationManagerBuilder**"+auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()));
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		 String password = "password";		 
	     String encrytedPassword = this.passwordEncoder().encode(password);
		auth.inMemoryAuthentication().withUser("user").password(encrytedPassword).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(encrytedPassword).roles("ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// All requests send to the Web Server request must be authenticated
        http.authorizeRequests().anyRequest().authenticated();
        // Use AuthenticationEntryPoint to authenticate user/password
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().
		authenticationEntryPoint(entryPoint);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
	//*******************************************************************
	/*  @Autowired 
	  public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	  
	  String password = "password";		 
	     String encrytedPassword = this.passwordEncoder().encode(password);
		auth.inMemoryAuthentication().withUser("user").password(encrytedPassword).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(encrytedPassword).roles("ADMIN");
      }
	 

	
	 @Override 
	 protected void configure(HttpSecurity http) throws Exception {
	 	http.csrf().disable();
		// All requests send to the Web Server request must be authenticated
        http.authorizeRequests().anyRequest().authenticated();
        // Use AuthenticationEntryPoint to authenticate user/password
	 	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	 }
	 
		
	 */
	
	
	
}
