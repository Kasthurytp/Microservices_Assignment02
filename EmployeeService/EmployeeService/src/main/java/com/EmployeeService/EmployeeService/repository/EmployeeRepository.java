package com.EmployeeService.EmployeeService.repository;


import com.EmployeeService.EmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
    List<Employee> findByemployeeid(BigInteger id);
    List<Employee> findBydepartmentid(BigInteger id);
}
