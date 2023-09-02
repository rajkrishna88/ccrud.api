package com.api.demo.services;

import com.api.demo.entity.Employee;

import java.util.List;

public interface EmployeeServices {

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Integer eid,Employee employee);

    public Employee getEmployeeById(Integer eid);

    public List<Employee> getAllEmployees();

    public Employee deleteEmployee(Integer eid);

}
