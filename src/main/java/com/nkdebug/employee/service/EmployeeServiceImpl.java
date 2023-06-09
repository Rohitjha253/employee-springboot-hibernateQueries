package com.nkdebug.employee.service;

import com.nkdebug.employee.dao.EmployeeDAO;
import com.nkdebug.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int theId) {
    return employeeDAO.findById(theId);
  }

  @Override
  @Transactional
  public void save(Employee theEmployee) {
    employeeDAO.save(theEmployee);
  }

  @Override
  @Transactional
  public void delete(int theId) {
    employeeDAO.delete(theId);
  }
}
