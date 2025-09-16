package com.tpelikan.store.repo;

import org.springframework.stereotype.Repository;
import com.tpelikan.store.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {



}
