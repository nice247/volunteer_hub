package com.vho.activ.service;

import com.vho.activ.models.Attendance;
import com.vho.activ.repo.AttendanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AttendanceService {
    private final AttendanceRepo attendanceRepo;

    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    public List<Attendance> getAttendanceRepo() {
        return attendanceRepo.findAll();
    }
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

}
