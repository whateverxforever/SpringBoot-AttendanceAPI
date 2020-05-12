package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("studentDao") StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(String id){
        return studentDao.selectStudentById(id);
    }

    public int deleteStudentById(String id){
        return studentDao.deleteStudentById(id);
    }

    public int updateStudentById(String id, Student student){
        return studentDao.updateStudentById(id, student);
    }
}
