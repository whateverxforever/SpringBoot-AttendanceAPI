package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Attendance {

    private final UUID id;
    private final String courseId;
    private final Date date;
    private final List<String> attendance;

    public Attendance(@JsonProperty("id") UUID id, @JsonProperty("date") Date date,
                      @JsonProperty("courseId") String courseId, @JsonProperty("attendance") List<String> attendance){
        this.id = id;
        this.courseId = courseId;
        this.date = date;
        this.attendance = attendance;
    }

    public UUID getId() {
        return id;
    }

    public List<String> getAttendance() {
        return attendance;
    }

    public Date getDate() {
        return date;
    }

    public String getCourseId() {
        return courseId;
    }
}
