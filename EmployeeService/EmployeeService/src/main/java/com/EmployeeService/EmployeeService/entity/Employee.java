package com.EmployeeService.EmployeeService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.math.BigInteger;
@Entity
@IdClass(Employeeid.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee {
    @Id
    @GeneratedValue
    private BigInteger employeeid;

    @Id
    private BigInteger departmentid;
    private String employeename;

    public Employee(){

    }

    public BigInteger getEmployeeid() {
        return employeeid;
    }

    public BigInteger getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(BigInteger departmentid) {
        this.departmentid = departmentid;
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
