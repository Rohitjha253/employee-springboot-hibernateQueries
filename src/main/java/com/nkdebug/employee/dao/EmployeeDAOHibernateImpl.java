package com.nkdebug.employee.dao;

import com.nkdebug.employee.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{


  // define field for entity manager

  private EntityManager entityManager;

  // setup constructor injection
  @Autowired
  public EmployeeDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {

    // get current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // create a query
    Query<Employee> theQuery =
            currentSession.createQuery("from Employee", Employee.class);

    List<Employee> employees = theQuery.getResultList();

    return employees;
  }

  @Override
  public Employee findById(int theId) {
    // get current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    Employee theEmployee = currentSession.get(Employee.class, theId);

    return theEmployee;
  }

  @Override
  public void save(Employee theEmployee) {
    // get current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // save employee object
    currentSession.saveOrUpdate(theEmployee);
  }

  @Override
  public void delete(int theId) {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Employee> theQuery =
      currentSession.createQuery("delete from Employee where id=:employeeId");
    theQuery.setParameter("employeeId", theId);
    theQuery.executeUpdate();

  }
}
