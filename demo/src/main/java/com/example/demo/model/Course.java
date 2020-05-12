package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Course {

    private final String id;
    private final String faculty;
    private final List<Student> students;
    private final List<Attendance> attendance;

    public Course(@JsonProperty("id") String id,
                  @JsonProperty("faculty") String faculty,
                  @JsonProperty("student") List<Student> students,
                  @JsonProperty("attendance") List<Attendance> attendance ){
        this.id = id;
        this.faculty = faculty;
        this.students = students;
        this.attendance = attendance;
    }

    public String getId() {
        return id;
    }

    public String getFaculty() {
        return faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }
}
