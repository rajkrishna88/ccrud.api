package com.api.demo.repository;

import com.api.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EmployeeRespository extends JpaRepository<Employee, Serializable> {
}
