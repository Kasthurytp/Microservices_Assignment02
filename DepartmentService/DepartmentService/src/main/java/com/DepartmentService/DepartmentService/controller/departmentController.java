package com.DepartmentService.DepartmentService.controller;


import com.DepartmentService.DepartmentService.entity.Department;
import com.DepartmentService.DepartmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class departmentController {
    @Autowired
    private DepartmentRepository departmentrepository;

    @GetMapping("/")
    public String getHomePage(){
        return " Department page is working";
    }

    @GetMapping("/department")
    public List<Department> getDepartment(){
        return departmentrepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getSpecificDepartment(@PathVariable("id") BigInteger id){return  departmentrepository.getOne(id);
    }
    @PostMapping("/")
    public void saveDepartment(@RequestBody Department departmententity) {
        departmentrepository.save(departmententity);
    }
    @DeleteMapping("/")
    public void deleteDepartment(@PathVariable BigInteger id){
        departmentrepository.deleteById(id);
    }

    @PutMapping("/")
    public void updateCourse(@RequestBody Department department){
        Department existingDepartment = departmentrepository.findById(department.getDepartmentid()).orElse(null);
        existingDepartment.setDepartmentname(department.getDepartmentname());
        departmentrepository.save(existingDepartment);
    }

}
