package com.tpelikan.SpringSecuriteEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpelikan.SpringSecuriteEx.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>  {


	Users findByUsername(String username);
	
	 

}
