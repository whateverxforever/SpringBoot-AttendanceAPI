package com.example.demo.dao;

import com.example.demo.model.Attendance;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("attendanceDao")
public class AttendanceDataAccessService implements AttendanceDao {

    private static List<Attendance> DB = new ArrayList<>();

    @Override
    public int insertAttendance(UUID id, Attendance attendance) {
        DB.add(new Attendance(id, attendance.getDate(), attendance.getCourseId(), attendance.getAttendance()));
        return 1;
    }

    @Override
    public List<Attendance> selectAllAttendance() {
        return DB;
    }

    @Override
    public Optional<Attendance> selectAttendanceById(UUID id) {
        return DB.stream()
                .filter(attendance -> attendance.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateAttendanceById(UUID id, Attendance attendance) {
        return selectAttendanceById(id)
                .map(s -> {
                    int index = DB.indexOf(s);
                    if(index >= 0){
                        DB.set(index, new Attendance(id, attendance.getDate(),
                                attendance.getCourseId(),  attendance.getAttendance()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}


