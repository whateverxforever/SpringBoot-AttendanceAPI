package com.example.demo.api;

import com.example.demo.model.Attendance;
import com.example.demo.model.Student;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/attendance")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) { this.attendanceService = attendanceService; }

    @PostMapping
    public void addAttendance(@RequestBody Attendance attendance){
        attendanceService.addAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAllStudents(){
        return attendanceService.getAllAttendance();
    }

    @GetMapping(path = "{id}")
    public Attendance getAttendanceById(@PathVariable("id") UUID id){
        return attendanceService.getAttendanceById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateAttendanceById(@PathVariable("id") UUID id, @RequestBody Attendance attendance){
        attendanceService.updateAttendanceById(id, attendance);
    }
}
