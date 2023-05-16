package com.nkdebug.employee.controller;

import com.nkdebug.employee.dao.EmployeeDAO;
import com.nkdebug.employee.entity.Employee;
import com.nkdebug.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return  employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee findAll(@PathVariable int employeeId) {
      Employee theEmployee = employeeService.findById(employeeId);
      if(theEmployee == null) {
        throw new RuntimeException("Employee Id not found -"+ employeeId);
      }

      return theEmployee;
  }

  @PostMapping("/employees")
  public Employee save(@RequestBody Employee theEmployee) {

    theEmployee.setId(0);
    employeeService.save(theEmployee);

    return theEmployee;
  }

  @PutMapping("/employees")
  public Employee update(@RequestBody Employee theEmployee) {

    employeeService.save(theEmployee);

    return theEmployee;
  }

  @DeleteMapping("/employees/{employeeId}")
  public String delete(@PathVariable int employeeId) {

    employeeService.delete(employeeId);

    return "Employee with employeeId -" +employeeId + "is deleted";
  }




}
