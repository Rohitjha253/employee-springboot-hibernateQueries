package com.nkdebug.employee.service;

import com.nkdebug.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

  public List<Employee> findAll();

  public Employee findById(int theId);

  public void save(Employee theEmployee);

  public void delete(int theId);

}
