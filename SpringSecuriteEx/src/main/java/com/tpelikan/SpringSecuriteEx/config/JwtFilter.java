package com.tpelikan.SpringSecuriteEx.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tpelikan.SpringSecuriteEx.service.JWTService;
import com.tpelikan.SpringSecuriteEx.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;
	
	
	@Autowired
	private ApplicationContext context;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("*************** test ************************");
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		
		System.out.println("authHeader=" + authHeader);
		
		if (authHeader != null && authHeader.startsWith("Bearer " )) {
			token = authHeader.substring(7);
			
			System.out.println("jwtService= " + jwtService);
			
			userName = jwtService.extractUserName(token);
			
			System.out.println("toke = " + token + " userName= " + userName);
			
		}
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
			
			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails,  null, userDetails.getAuthorities());
				userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userToken);
			}
		}
		
		
		
		filterChain.doFilter(request, response);
		
	}

}
