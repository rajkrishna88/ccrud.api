package com.api.demo.services;

import com.api.demo.entity.Employee;
import com.api.demo.exception.EmployeeNotFoundException;
import com.api.demo.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    private EmployeeRespository repo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer eid, Employee employee) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
            employee.setEid(eid);
            return repo.save(employee);
        }else
        throw new EmployeeNotFoundException("Employee not found with id : "+eid);
    }

    @Override
    public Employee getEmployeeById(Integer eid) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
           return byId.get();
        }
        throw new EmployeeNotFoundException("Employee not found with id : "+eid);

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> all = repo.findAll();
        return all;
    }

    @Override
    public Employee deleteEmployee(Integer eid) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
            repo.deleteById(eid);
            return byId.get();
        }
        throw new EmployeeNotFoundException("Employee not found with id : "+eid);
    }
}
