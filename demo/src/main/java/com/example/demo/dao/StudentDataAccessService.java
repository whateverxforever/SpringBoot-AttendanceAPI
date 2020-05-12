package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("studentDao")
public class StudentDataAccessService implements StudentDao{

    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(Student student) {
        DB.add(new Student(student.getId(), student.getName()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return DB;
    }

    @Override
    public Optional<Student> selectStudentById(String id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteStudentById(String id) {
        Optional<Student> student = selectStudentById(id);
        if(student.isEmpty()){
            return 0;
        }
        DB.remove(student.get());
        return 1;
    }

    @Override
    public int updateStudentById(String id, Student student) {
        return selectStudentById(id)
                .map(s -> {
                    int index = DB.indexOf(s);
                    if(index >= 0){
                        DB.set(index, new Student(id, student.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
