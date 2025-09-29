package com.tpelikan.SpringSecuriteEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.tpelikan.SpringSecuriteEx.model.Users;
import com.tpelikan.SpringSecuriteEx.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public Users register(Users user) {
		return userRepo.save(user);	
	}

	public String verify(Users user) {
		
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		if (authenticate.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		
		
		return "Failed";
	}

}
