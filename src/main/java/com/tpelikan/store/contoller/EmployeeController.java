package com.tpelikan.store.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tpelikan.store.entity.Employee;
import com.tpelikan.store.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "Example Header Value");
//        headers.add("Content-Type", "application/json");
		
		return new ResponseEntity<>(employeeService.getAllEmployees(), headers, HttpStatus.OK);
	}
	
//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees() {
//		return employeeService.getAllEmployees();
//	}
	
	
	@GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeee(@PathVariable int id) {
		
		Employee employee = employeeService.getEmployee(id);
		
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return  new ResponseEntity<>(employee, HttpStatus.OK);   
    }
	    
//    @PostMapping("/employees")
//    public void createEmployee(@RequestBody  Employee  employee) { 
//    	employeeService.createEmployee(employee);
//    }

	@PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestPart Employee employee, @RequestPart MultipartFile imageFile) {
		
		System.out.println("employee:" + employee);
		System.out.println("imageFile:" + imageFile);
		
		try {
			Employee newEmployee = employeeService.addEmployee(employee, imageFile);
			return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/employee/{employeeId}/image")
	public ResponseEntity<byte[]> getImagByEmployeeId(@PathVariable int employeeId) {
		System.out.println("employee id:" +  employeeId);
		Employee employee = employeeService.getEmployee(employeeId);
		byte[] imageFile = employee.getImageDate();
		
		return ResponseEntity.ok().contentType(MediaType.valueOf(employee.getImageType())).body(imageFile);
		
	}
	
    
}
