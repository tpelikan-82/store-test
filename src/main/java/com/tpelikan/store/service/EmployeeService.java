package com.tpelikan.store.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tpelikan.store.entity.Employee;
import com.tpelikan.store.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	   
    public Employee getEmployee (int id) {
    	return employeeRepo.findById(id).orElse(null);    	
    }
	    
 
    public void createEmployee(Employee  employee) {
    	System.out.println(employee + " ");
    	employeeRepo.save(employee);
    }
    
    public void updateEmployee(Employee employee) {
    	employeeRepo.save(employee);
    }
    
    public void deleteEmployee(Employee employee) {
    	employeeRepo.delete(employee);
    }
    
    public void deleteEmployeeById(int id) {
    	employeeRepo.deleteById(id);
    }


	public Employee addEmployee(Employee employee, MultipartFile imageFile) throws IOException {
		employee.setImageName(imageFile.getOriginalFilename());
		employee.setImageType(imageFile.getContentType());
		employee.setImageDate(imageFile.getBytes());
		return employeeRepo.save(employee);
	}


	public Employee updateEmployee(Employee employee, MultipartFile imageFile) throws IOException {
		employee.setImageDate(imageFile.getBytes());
		employee.setImageName(imageFile.getOriginalFilename());
		employee.setImageType(imageFile.getContentType());
		return employeeRepo.save(employee);		
	}


	public List<Employee> searchEmployees(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepo.searchEmployees(keyword);
	}
    
    
	
}
