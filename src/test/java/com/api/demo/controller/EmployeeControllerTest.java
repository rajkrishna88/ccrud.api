//package com.api.demo.controller;
//
//import com.api.demo.entity.Employee;
//import com.api.demo.services.EmployeeServiceImpl;
//import com.api.demo.services.EmployeeServices;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.models.Model;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ContextConfiguration(classes = {EmployeeController.class})
//@ExtendWith(SpringExtension.class)
//class EmployeeControllerTest {
//
//    @MockBean
//    private EmployeeServices employeeServices;
//
//    @Autowired
//    private EmployeeController employeeController;
//    @Test
//    void createEmployees() throws Exception {
//        Employee employee=new Employee(101,"Rabindra","GRD","rabindra@gmail.com");
//        ObjectMapper objectMapper= new ObjectMapper();
//        String s = objectMapper.writeValueAsString(employee);
//        when(employeeServices.saveEmployee(Mockito.any(Employee.class))).thenReturn(employee);
//        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/employee")
//                .accept(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(employee));
//        MockMvcBuilders.standaloneSetup(this.employeeController)
//                .build()
//                .perform(content)
//               // .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.content().string(s))
//                .andReturn().getResponse().equals(s);
//    }
//
////    @Test
////    void getEmployeeById() {
////    }
////
////    @Test
////    void getAllEmployee() {
////    }
////
////    @Test
////    void updateEmployee() {
////    }
////
////    @Test
////    void deleteEmployee() {
////    }
//}