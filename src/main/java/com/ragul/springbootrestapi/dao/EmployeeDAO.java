package com.ragul.springbootrestapi.dao;

import com.ragul.springbootrestapi.model.Employee;
import com.ragul.springbootrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;

    //Save employee
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //search all employees
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //get a employee by id
    public Employee findOne(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    //delete employee by object
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }


}
