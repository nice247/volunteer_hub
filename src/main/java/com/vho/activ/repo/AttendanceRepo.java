package com.vho.activ.repo;

import com.vho.activ.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    Attendance findAttendanceByActivity_ActId(Long actId);
    Attendance findAttendanceByVolunteer_VolIdAndActivity_ActId(Long volId, Long actId);
    List <Attendance> findAttendancesByVolunteer_VolId(Long volId);
    List <Attendance> findAttendanceByActivity_Committee_CommId(Long committeeId);
    List <Attendance> findAttendancesByVolunteer_VolIdAndActivity_ActDateBetween(Long volId, LocalDate startDate, LocalDate endDate);

}
