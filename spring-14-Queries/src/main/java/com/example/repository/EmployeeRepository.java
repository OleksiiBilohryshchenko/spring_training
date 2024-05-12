package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address ""
    List<Employee> findAllByEmail(String email);

    //Display all employees with firstname "" and last name ""
    //also show all employees with email address ""
    List<Employee> findAllByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees which first name is not ""
    List<Employee> findAllByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ""
    List<Employee> findAllByLastNameStartingWith(String lastName);

    //Display all employees with salary higher than ""
    List<Employee> findAllBySalaryGreaterThan(Integer salary);

    //Display all employees with salary less than ""
    List<Employee> findAllBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findAllByHireDateBetween(LocalDate startFate, LocalDate endDate);

    //Display all employees where salary is greater and equal to "" in order-salary
    List<Employee> findAllBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees who are making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan (Integer salary);

    //Display all employees that do not have email address
    List<Employee> findAllByEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

}
