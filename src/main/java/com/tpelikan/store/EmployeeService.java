package com.tpelikan.store;

import java.util.ArrayList;
import java.util.List;

import com.tpelikan.store.entity.Employee;
import com.tpelikan.store.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class EmployeeService {
    
	private List<Employee> employees = new ArrayList<Employee>();
	
	@Autowired
	EmployeeRepo repo;
	
	
//   @RequestMapping("/employees")
//    public List<Employee> getAllEmployees() {
//    	System.out.println("getAllEmployees");
//    	Employee e = new Employee();
//    	e.setName("tomas");
//    	employees.add(e);
//        return employees;
//    }
	
	
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
    	System.out.println("getAllEmployees");
        return repo.findAll();
    }

    
    @GetMapping("/employees/{id}")
    public Employee getEmployeee(@PathVariable int id) {
    	return repo.findById(id).orElse(new Employee());    	
    }
    
    @PostMapping("/employees")
    public void createEmployee(@RequestBody  Employee  employee) {
    	System.out.println(employee + " " + employee.getEmployeeId());
    	repo.save(employee);
    }
    
    public void updateEmployee(Employee employee) {
    	repo.save(employee);
    }
    
    public void deleteEmployee(Employee employee) {
    	repo.delete(employee);
    }
    
    public void deleteEmployeeById(int id) {
    	repo.deleteById(id);
    }
    
}