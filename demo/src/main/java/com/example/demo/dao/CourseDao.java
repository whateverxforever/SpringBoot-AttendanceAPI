package com.example.demo.dao;

import com.example.demo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {

    int insertCourse(Course course);

    List<Course> selectAllCourses();

    Optional<Course> selectCourseById(String id);

    int deleteCourseById(String id);

    int updateCourseById(String id, Course course);

}
