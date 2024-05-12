package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

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

}
