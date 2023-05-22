package com.EmployeeService.EmployeeService.controller;


import com.EmployeeService.EmployeeService.entity.Employee;
import com.EmployeeService.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHomePage(){
        return " Employee page is working";
    }

    @GetMapping("/department")
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getSpecificEmployee(@PathVariable("id") BigInteger id){return  employeeRepository.getOne(id);
    }

    @PostMapping("/")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }
    @DeleteMapping("/")
    public void deleteEmployee(@PathVariable BigInteger id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/")
    public void updateCourse(@RequestBody Employee employee){
        Employee existingDepartment = employeeRepository.findById(employee.getEmployeeid()).orElse(null);
        existingDepartment.setEmployeename(employee.getEmployeename());
        employeeRepository.save(existingDepartment);
    }
    @GetMapping("/Employee/{id}")
    public List<Employee> getEmployeesForADepartment(@PathVariable("id") BigInteger id) {
        return employeeRepository.findBydepartmentid(id);
    }




}
