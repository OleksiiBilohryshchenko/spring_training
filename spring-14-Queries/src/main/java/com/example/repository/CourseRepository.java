package com.example.repository;

import com.example.entity.Course;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository <Course,Long>{

    //Find all courses by category select * from courses where category = ...
    List<Course> findByCategory(String category);

    //Find all courses by categories and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Check if a course with the supplier exists. Return true if exists, false if not.
    boolean existsByName(String name);

    //Return a count of courses for given category
    int countByCategory(String category);

    //Find all the courses that starts with "" given course name string
    List<Course> findAllByNameStartingWith (String name);

    //Find all courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);


}
