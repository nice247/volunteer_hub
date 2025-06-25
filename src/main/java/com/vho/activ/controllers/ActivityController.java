package com.vho.activ.controllers;

import com.vho.activ.models.Activity;
import com.vho.activ.models.Apology;
import com.vho.activ.models.Attendance;
import com.vho.activ.service.ActivityService;
import com.vho.activ.service.ApologyService;
import com.vho.activ.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/activities")
@AllArgsConstructor
public class ActivityController {

    private ActivityService activityService;
    private AttendanceService attendanceService;
    private ApologyService apologyService;

    @GetMapping("/comm/{id}/activities")
    public List<Activity> getActivityByCommId(@PathVariable Long id) {
        return activityService.getAllActivitiesByCommitteeId(id);
    }
    @GetMapping("/attendance/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }
    @GetMapping("/activities/{id}/attendance")
    public Attendance getAttendByActId(@PathVariable Long id) {
        return attendanceService.getAttendanceByActivity_ActId(id);
    }
    @GetMapping("/volunteer/{id}/attendance")
    public List<Attendance> getVolunteerAttendanceBetween(@PathVariable Long id,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate) {

        return attendanceService.getAttendByVolunteerIdAndActivity_DateBetween(id, startDate, endDate);
    }
    @GetMapping("/{id}/apologies")
    public List<Apology> getApologiesByActivityId(@PathVariable Long id) {
        return apologyService.getAllApologiesByActivityId(id);
    }
    @GetMapping("/apologies")
    public List<Apology> getAllApologies(){
        return apologyService.getAllApologies();
    }
    @PostMapping("/{id}/chick-in/{volId}")
    public Attendance chickInAttendance(@PathVariable Long id, @PathVariable Long volId) {
        return attendanceService.checkInAttendance(id, volId);
    }
    @PutMapping("/{id}/chick-out/{volId}")
    public Attendance chickOutAttendance(@PathVariable Long volId, @PathVariable Long id) {
        return attendanceService.checkOutAttendance(volId, id);
    }

}
