package com.ragul.springbootrestapi.repository;


import com.ragul.springbootrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
