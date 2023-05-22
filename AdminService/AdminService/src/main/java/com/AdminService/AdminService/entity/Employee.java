package com.AdminService.AdminService.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigInteger;

public class Employee {
    @Id
    @GeneratedValue
    private BigInteger employeeid;
    private BigInteger departmentid;
    private String employeename;



    public Employee(){

    }

    public BigInteger getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(BigInteger departmentid) {
        this.departmentid = departmentid;
    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigInteger employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
}
