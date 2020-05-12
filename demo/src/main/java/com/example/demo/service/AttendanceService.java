package com.example.demo.service;

import com.example.demo.dao.AttendanceDao;
import com.example.demo.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttendanceService {

    private final AttendanceDao attendanceDao;

    @Autowired
    public AttendanceService(@Qualifier("attendanceDao") AttendanceDao attendanceDao) { this.attendanceDao = attendanceDao;}

    public int addAttendance(Attendance attendance){ return attendanceDao.insertAttendance(attendance);}

    public List<Attendance> getAllAttendance() { return attendanceDao.selectAllAttendance(); }

    public Optional<Attendance> getAttendanceById(UUID id){
        return attendanceDao.selectAttendanceById(id);
    }

    public int updateAttendanceById(UUID id, Attendance attendance){ return attendanceDao.updateAttendanceById(id, attendance); }

}
