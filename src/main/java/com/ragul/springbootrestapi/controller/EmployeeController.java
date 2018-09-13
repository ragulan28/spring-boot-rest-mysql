package com.ragul.springbootrestapi.controller;

import com.ragul.springbootrestapi.dao.EmployeeDAO;
import com.ragul.springbootrestapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/company")
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    //save employee
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeDAO.save(employee);
    }

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeDAO.findAll();
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        Employee employee=employeeDAO.findOne(id);
        if (isEmpty(employee)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(employee);
    }



    //update employee by
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee>  updateEmployee(@PathVariable(value = "id") Long id, @Valid @RequestBody Employee employeeDetails){
        Employee employee=employeeDAO.findOne(id);
        if (isEmpty(employee)) return ResponseEntity.notFound().build();

        employee.setName(employeeDetails.getName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setExpertise(employeeDetails.getExpertise());

        Employee updatedEmployee=employeeDAO.save(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    //delete employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> delete(@PathVariable(value = "id") Long id){

        Employee employee=employeeDAO.findOne(id);
        if (isEmpty(employee)) return ResponseEntity.notFound().build();

        employeeDAO.delete(employee);
        return ResponseEntity.ok().build();
    }

    private boolean isEmpty(Employee employee) {
        if(employee==null){
            return true;
        }
        return false;
    }
}
