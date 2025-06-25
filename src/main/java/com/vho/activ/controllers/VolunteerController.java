package com.vho.activ.controllers;

import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
@AllArgsConstructor
public class VolunteerController {

    private VolunteerService volunteerService;
    private EvaluationService evaluationService;
    private ApologyService apologyService;
    private AttendanceService attendanceService;
    private NotificationService notificationService;
    private TaskService taskService;
    private TrainingService trainingService;
    private ReportService reportService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getVolunteerById(@PathVariable Long id) {
        try {
            Volunteer volunteer = volunteerService.getVolunteerById(id);
            if (volunteer == null)
                return ResponseEntity.status(404).body("Volunteer not found");
            return ResponseEntity.ok(volunteer);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/attends")
    public ResponseEntity<?> getAttendanceByVolunteerId(@PathVariable Long id) {
        try {
            List<Attendance> attendances = attendanceService.getAttendanceByVolunteerId(id);
            if (attendances.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(attendances);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/notify")
    public ResponseEntity<?> getNotificationByRecipientId(@PathVariable Long id) {
        try {
            Notification notification = notificationService.getNotificationByRecipientId(id);
            if (notification == null)
                return ResponseEntity.status(404).body("Notification not found");
            return ResponseEntity.ok(notification);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/trainings")
    public ResponseEntity<?> getTrainingByVolunteerId(@PathVariable Long id) {
        try {
            List<Training> trainings = trainingService.getAllTrainingByVolunteerId(id);
            if (trainings.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(trainings);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/task")
    public ResponseEntity<?> getTaskByVolunteerId(@PathVariable Long id) {
        try {
            Task task = taskService.getTaskByAssignedTo(id);
            if (task == null)
                return ResponseEntity.status(404).body("Task not found");
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/evaluation")
    public ResponseEntity<?> getEvaluationByVolunteerId(@PathVariable Long id) {
        try {
            Evaluation evaluation = evaluationService.getEvaluationsByEvaluatedId(id);
            if (evaluation == null)
                return ResponseEntity.status(404).body("Evaluation not found");
            return ResponseEntity.ok(evaluation);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/apology")
    public ResponseEntity<?> addApology(@RequestBody Apology apology) {
        try {
            Apology apology1 = apologyService.saveApology(apology);
            return ResponseEntity.status(201).body(apology1);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @PostMapping("/report")
    public ResponseEntity<?> addReport(@RequestBody Report report) {
        try {
            Report report1 = reportService.saveReport(report);
            return ResponseEntity.status(201).body(report1);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
