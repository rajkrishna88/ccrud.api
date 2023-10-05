package com.api.demo.services;

import com.api.demo.entity.Employee;
import com.api.demo.exception.EmployeeNotFoundException;
import com.api.demo.repository.EmployeeRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {EmployeeServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @MockBean
    private EmployeeRespository employeeRespository;
    @Autowired
    private EmployeeServices  employeeServices;
    @Test
    void saveEmployee() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        when(employeeRespository.save(Mockito.any(Employee.class))).thenReturn(employee);
        assertSame(employee,employeeServices.saveEmployee(employee));

    }

    @Test
    void updateEmployee() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        when(employeeRespository.findById(any(Integer.class))).thenReturn(Optional.of(employee));
        when(employeeRespository.save(employee)).thenReturn(employee);
        assertSame(employee,employeeServices.updateEmployee(101,employee));
    }

    @Test
    void updateEmployee_failed() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        when(employeeRespository.save(Mockito.<Employee>any())).thenThrow(new EmployeeNotFoundException("Employee not found"));
        assertThrows(EmployeeNotFoundException.class,()->employeeServices.updateEmployee(1,employee));
    }

    @Test
    void getEmployeeById() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        when(employeeRespository.findById(any(int.class))).thenReturn(Optional.of(employee));
        assertSame(employee,employeeServices.getEmployeeById(101));
    }

    @Test
    void getEmployeeById_failed() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        when(employeeRespository.findById(any())).thenThrow(new EmployeeNotFoundException("error"));
        assertThrows(EmployeeNotFoundException.class, () -> employeeServices.getEmployeeById(102) );
    }

    @Test
    void getAllEmployees() {
        Employee employee1=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        Employee employee2=new Employee(102,"Raj","CTC","raj@gmail.com");
        List<Employee> employees = Arrays.asList(employee1, employee2);
        when(employeeRespository.findAll()).thenReturn(employees);
        assertSame(employees,employeeServices.getAllEmployees());
    }

    @Test
    void deleteEmployee() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        doNothing().when(employeeRespository).deleteById(101);
        when(employeeRespository.findById(any())).thenReturn(Optional.of(employee));
        assertSame(employee,employeeServices.deleteEmployee(101));
    }

    @Test
    void deleteEmployee_failed() {
        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
        doNothing().when(employeeRespository).deleteById(101);
        when(employeeRespository.findById(any())).thenThrow(new EmployeeNotFoundException("error"));
        assertThrows(EmployeeNotFoundException.class, () -> employeeServices.deleteEmployee(1));
    }
}