package com.tpelikan.store.repo;

import org.springframework.stereotype.Repository;
import com.tpelikan.store.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("SELECT e from Employee e WHERE " +
	"e.lastName LIKE CONCAT('%', :keyword, '%')")
	List<Employee> searchEmployees(String keyword);



}
