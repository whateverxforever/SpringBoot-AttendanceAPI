package com.example.demo.dao;

import com.example.demo.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("courseDao")
public class CourseDataAccessService implements CourseDao {

    private  static List<Course> DB = new ArrayList<>();

    @Override
    public int insertCourse(Course course) {
        DB.add(new Course(course.getId(), course.getFaculty(), course.getStudents(), course.getAttendance()));
        return 1;
    }

    @Override
    public List<Course> selectAllCourses() {
        return DB;
    }

    @Override
    public Optional<Course> selectCourseById(String id) {
        return DB.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCourseById(String id) {
        Optional<Course> course = selectCourseById(id);
        if(course.isEmpty()){
            return 0;
        }
        DB.remove(course.get());
        return 1;
    }

    @Override
    public int updateCourseById(String id, Course course) {
        return selectCourseById(id)
                .map(c -> {
                    int index = DB.indexOf(c);
                    if(index >= 0){
                        DB.set(index, new Course(id, course.getFaculty(),
                                course.getStudents(), course.getAttendance()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
