package com.example.repository;

import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //Not Equal (position)
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / StartsWith / EndsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike (String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHiredDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailNotNull();

    //Sorting in Ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //Sorting in Descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDsc();

    //Native Query (table name)
    @Query(value = "SELECT * FROM employees WHERE salary =?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary")int salary);


}
