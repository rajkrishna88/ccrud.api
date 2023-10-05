package com.api.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Valid
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Integer eid;
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Size(min = 3,max = 15,message = "city size must be between 3 and 15")
    @NotEmpty(message = "")
    private String city;
    @Email(message ="valid email")
    @NotEmpty
    private String email;


}
