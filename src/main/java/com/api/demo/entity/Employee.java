package com.api.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Integer eid;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "City cannot be null")
    private String city;
    @Email(message = "Not valid email")
    private String email;


}
