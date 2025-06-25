package com.vho.activ.controllers;

import com.vho.activ.models.Activity;
import com.vho.activ.models.Apology;
import com.vho.activ.models.Attendance;
import com.vho.activ.service.ActivityService;
import com.vho.activ.service.ApologyService;
import com.vho.activ.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getActivityByCommId(@PathVariable Long id) {
        try {
            List<Activity> activities = activityService.getAllActivitiesByCommitteeId(id);
            if (activities.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(activities);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<?> getAttendanceById(@PathVariable Long id) {
        try {
            Attendance attendance = attendanceService.getAttendanceById(id);
            if (attendance == null)
                return ResponseEntity.status(404).body("Attendance not found");
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/activities/{id}/attendance")
    public ResponseEntity<?> getAttendByActId(@PathVariable Long id) {
        try {
            Attendance attendance = attendanceService.getAttendanceByActivity_ActId(id);
            if (attendance == null)
                return ResponseEntity.status(404).body("Attendance not found");
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/volunteer/{id}/attendance")
    public ResponseEntity<?> getVolunteerAttendanceBetween(@PathVariable Long id,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        try {
            List<Attendance> attendances = attendanceService.getAttendByVolunteerIdAndActivity_DateBetween(id, startDate, endDate);
            if (attendances.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(attendances);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/apologies")
    public ResponseEntity<?> getApologiesByActivityId(@PathVariable Long id) {
        try {
            List<Apology> apologies = apologyService.getAllApologiesByActivityId(id);
            if (apologies.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(apologies);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/apologies")
    public ResponseEntity<?> getAllApologies() {
        try {
            List<Apology> apologies = apologyService.getAllApologies();
            if (apologies.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(apologies);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/chick-in/{volId}")
    public ResponseEntity<?> chickInAttendance(@PathVariable Long id, @PathVariable Long volId) {
        try {
            Attendance attendance = attendanceService.checkInAttendance(id, volId);
            if (attendance == null)
                return ResponseEntity.status(404).body("Attendance not found");
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/chick-out/{volId}")
    public ResponseEntity<?> chickOutAttendance(@PathVariable Long volId, @PathVariable Long id) {
        try {
            Attendance attendance = attendanceService.checkOutAttendance(volId, id);
            if (attendance.getCheckIn() == null)
                return ResponseEntity.status(404).body("Attendance not found");
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
