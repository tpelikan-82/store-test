package com.tpelikan.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    	System.out.println(employee + " " + employee.getEmployeeId());
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
	
}
