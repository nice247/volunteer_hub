package com.vho.activ.service;

import com.vho.activ.models.Attendance;
import com.vho.activ.repo.AttendanceRepo;
import com.vho.activ.repo.VolunteerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class AttendanceService {

    private AttendanceRepo attendanceRepo;
    private VolunteerService volunteerService;
    private ActivityService activityService;


    public Attendance checkInAttendance(Long volId, Long actId) {
        String status;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = activityService.getActivityById(actId).getStartTime();
        LocalDateTime endTime = activityService.getActivityById(actId).getEndTime();
        Duration duration = Duration.between(endTime, startTime);
        Duration diff = Duration.between(startTime, now);
        long period = duration.toMinutes();
        long minutesLate = diff.toMinutes();
        if (minutesLate <= 15 && minutesLate > 0)
            status = "Attended";
        else if (minutesLate > 15 && minutesLate < period)
            status = "Late";
        else
            status = "Not Attended";
        Attendance attendance = Attendance.builder()
                .volunteer(volunteerService.getVolunteerById(volId))
                .activity(activityService.getActivityById(actId))
                .status(status)
                .checkIn(now)
                .build();
        return attendanceRepo.save(attendance);
    }

    public Attendance checkOutAttendance(Long volId, Long actId) {
        Attendance attendance = attendanceRepo.findAttendanceByVolunteer_VolIdAndActivity_ActId(volId, actId);
        attendance.setCheckIn(LocalDateTime.now());

        Duration duration = Duration.between(attendance.getCheckIn(), LocalDateTime.now());

        int totalMinutes = (int) duration.toMinutes();

        attendance.setTotalMin(totalMinutes);
        return attendanceRepo.save(attendance);
    }

    public Attendance getAttendanceById(Long actId) {
        return attendanceRepo.findAttendanceByActivity_ActId(actId);
    }

    public Attendance getAttendanceByActivity_ActId(Long actId) {
        return attendanceRepo.findById(actId).get();
    }
    public List<Attendance> getAttendanceByCommitteeId(Long committeeId) {
        return attendanceRepo.findAttendanceByActivity_Committee_CommId(committeeId);
    }

    public List<Attendance> getAttendanceByVolunteerId(Long volId) {
        return attendanceRepo.findAttendancesByVolunteer_VolId(volId);
    }

    public List<Attendance> getAttendByVolunteerIdAndActivity_DateBetween(Long volId, LocalDate startDate, LocalDate endDate) {
        return attendanceRepo.findAttendancesByVolunteer_VolIdAndActivity_ActDateBetween(volId, startDate, endDate);
    }

}
