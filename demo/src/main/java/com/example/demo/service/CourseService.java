package com.example.demo.service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("courseDao") CourseDao courseDao){this.courseDao = courseDao; }

    public int addCourse(Course course){return courseDao.insertCourse(course); }

    public List<Course> getAllCourse(){return courseDao.selectAllCourses(); }

    public Optional<Course> getCourseById(String id){return courseDao.selectCourseById(id); }

    public int deleteCourseById(String id){return courseDao.deleteCourseById(id); }

    public int updateCourseById(String id, Course course){return courseDao.updateCourseById(id, course); }
}
