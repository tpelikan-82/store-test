package com.tpelikan.SpringSecuriteEx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class HelloController {

	@GetMapping("/")
	public String greet(HttpServletRequest httpServletRequest) {
		
		HttpSession session = httpServletRequest.getSession();
		
		
		
		return "hello your session id:" + session.getId();
	}
	
}
