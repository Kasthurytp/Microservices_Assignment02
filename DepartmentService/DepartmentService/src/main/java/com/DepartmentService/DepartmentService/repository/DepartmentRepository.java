package com.DepartmentService.DepartmentService.repository;


import com.DepartmentService.DepartmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DepartmentRepository extends JpaRepository<Department, BigInteger> {
}
