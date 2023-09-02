package com.api.demo.controller;

import com.api.demo.entity.Employee;
import com.api.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployees(@Valid @RequestBody Employee employee){
        Employee response = employeeServices.saveEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/employee/{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer eid){
        Employee response = employeeServices.getEmployeeById(eid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmployees = employeeServices.getAllEmployees();
        return new ResponseEntity<>(allEmployees,HttpStatus.OK);
    }

    @PutMapping("/employee/{eid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eid,@RequestBody Employee employee){
        Employee response = employeeServices.updateEmployee(eid, employee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @DeleteMapping("/employee/{eid}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int eid){
        Employee employee = employeeServices.deleteEmployee(eid);
        return new ResponseEntity<>(employee,HttpStatus.GONE);
    }
}
