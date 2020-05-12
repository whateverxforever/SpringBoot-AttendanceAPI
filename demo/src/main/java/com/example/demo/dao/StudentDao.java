package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(String id);

    int deleteStudentById(String id);

    int updateStudentById(String id, Student student);

}
