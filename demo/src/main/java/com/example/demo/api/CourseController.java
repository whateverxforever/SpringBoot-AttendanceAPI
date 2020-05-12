package com.example.demo.api;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/course")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){this.courseService = courseService;}

    @PostMapping
    public void addCourse(@RequestBody Course course){courseService.addCourse(course);}

    @GetMapping
    public List<Course> getAllCourses(){return courseService.getAllCourse();}

    @GetMapping(path="{id}")
    public Course getCourseById(@PathVariable("id") String id){
        return courseService.getCourseById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public int deleteCourseById(@PathVariable("id") String id){
        return courseService.deleteCourseById(id);
    }

    @PutMapping(path="{id}")
    public int updateCourseById(@PathVariable("id") String id, @RequestBody Course course){
        return courseService.updateCourseById(id, course);
    }

}
