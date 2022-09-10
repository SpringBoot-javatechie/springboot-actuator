package com.javatechie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.dto.Employee;
import com.javatechie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;


//    @GetMapping("/health")
//    public HttpStatus getHealth(){
//        return HttpStatus.OK;
//    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() throws JsonProcessingException {
        List<Employee> employees = service.getEmployees();
        log.info("EmployeeController:getAllEmployees fetch all employees {}",new ObjectMapper().writeValueAsString(employees));
        return employees;
    }
}
