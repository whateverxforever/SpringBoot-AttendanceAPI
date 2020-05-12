package com.example.demo.dao;

import com.example.demo.model.Attendance;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttendanceDao {
    int insertAttendance(UUID id, Attendance attendance);
    default int insertAttendance(Attendance attendance){
        UUID id = UUID.randomUUID();
        return insertAttendance(id, attendance);
    }

    List<Attendance> selectAllAttendance();

    Optional<Attendance> selectAttendanceById(UUID id);

    int updateAttendanceById(UUID id, Attendance attendance);
}
