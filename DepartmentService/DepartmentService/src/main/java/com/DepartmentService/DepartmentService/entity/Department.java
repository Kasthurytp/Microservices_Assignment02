package com.DepartmentService.DepartmentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigInteger;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private BigInteger departmentid;
    private String departmentname;


    public Department(){

    }

    public BigInteger getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(BigInteger departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
