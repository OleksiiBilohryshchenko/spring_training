package com.example.repository;

import com.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository <Course,Long>{

    //Find all courses by category select * from courses where category = ...
    List<Course> findByCategory(String category);

    //Find all courses by categories and order the entities by name
    List<Course> findByCategoryOrderByName(String category);



}
