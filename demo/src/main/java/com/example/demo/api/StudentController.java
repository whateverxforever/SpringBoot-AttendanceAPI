package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/student")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") String id){
        return studentService.getStudentById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") String id){
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudentById(@PathVariable("id") String id, @RequestBody Student student){
        studentService.updateStudentById(id, student);
    }

}
