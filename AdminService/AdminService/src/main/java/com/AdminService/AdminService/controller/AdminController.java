package com.AdminService.AdminService.controller;


import com.AdminService.AdminService.entity.Department;
import com.AdminService.AdminService.entity.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
public class AdminController {
    @Autowired
    EurekaClient client;

    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalogHome(){
        String DepartmentAppMessage="";
        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("employee-reg-app",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        DepartmentAppMessage = restTemplate.getForObject(courseAppURL,String.class);
        return("Department Catalog page: " + DepartmentAppMessage);
    }
    public String displayDefaultHome(){
        return("Welcome to Admin "+"please try after some time");
    }

    @GetMapping("/admin")
    public String getAdmin(){
        String Departments = "";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("employee-reg-app",false);
        String DepartmentAppURL = instanceInfo.getHomePageUrl();
        DepartmentAppURL = DepartmentAppURL+"/departments";
        RestTemplate  restTemplate = new RestTemplate();
        Departments = restTemplate.getForObject(DepartmentAppURL,String.class);
        return ("our Departments are " +Departments);
    }

    @GetMapping("/{id}")
    public String GetSpecificdepartment(@PathVariable("id") BigInteger id){
        Department department = new Department();
        Employee employee = new Employee();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("employee-reg-app",false );
        String DepartmentAppURL = instanceInfo.getHomePageUrl();
        DepartmentAppURL = DepartmentAppURL + "/" + id;
        RestTemplate  restTemplate = new RestTemplate();
        department = restTemplate.getForObject(DepartmentAppURL,Department.class);
        instanceInfo =client.getNextServerFromEureka("employee-reg-app",false);
        String EmployeeAppURL = instanceInfo.getHomePageUrl();
        EmployeeAppURL = EmployeeAppURL + "/departments/" + department.getDepartmentid();
        String employeesList = restTemplate.getForObject(EmployeeAppURL,String.class);
        return ("Course id is "+ department.getDepartmentid() +" and department name is "+ department.getDepartmentname() + " and work employees are " + employeesList);
    }
}
