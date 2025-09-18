package com.tpelikan.store.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	@Id
	private int id;
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Date validTo;
	

}
