package com.tpelikan.store.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	private String firstName;
	private  String lastName;
	
	
	public Employee() {
		
	}
	
	public Employee( int employeeId,  String firstName,  String lastName) {
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.employeeId = employeeId;
	}
	
	
	public void setName(String firstName) {
		this.firstName = firstName;		
	}
	
	public int getEmployeeId() {
		// TODO Auto-generated method stub
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}
}
