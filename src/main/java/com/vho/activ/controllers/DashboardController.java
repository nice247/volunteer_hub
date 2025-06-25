package com.vho.activ.controllers;

import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class DashboardController {

    private VolunteerService volunteerService;
    private ActivityService activityService;
    private ReportService reportService;
    private TrainingService trainingService;
    private EvaluationService evaluationService;
    private CommitteeService committeeService;
    private NotificationService notificationService;
    private TaskService taskService;

    @GetMapping("/{id}/evaluations")
    public ResponseEntity<?> getEvaluationsByEvaluator(@PathVariable Long id) {
        try {
            List<Evaluation> evaluations = evaluationService.getEvaluationsByEvaluatorId(id);
            if (evaluations.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(evaluations);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/report")
    public ResponseEntity<?> getReportByReporterId(@PathVariable Long id) {
        try {
            Report report = reportService.getReportByReporterId(id);
            if (report == null)
                return ResponseEntity.status(404).body("Report not found");
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<?> getReportByReportId(@PathVariable Long id) {
        try {
            Report report = reportService.getReportById(id);
            if (report == null)
                return ResponseEntity.status(404).body("Report not found");
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/volunteers")
    public ResponseEntity<?> getVolunteersByCommitteeId(@PathVariable Long id) {
        try {
            List<Volunteer> volunteers = volunteerService.getByCommitteeId(id);
            if (volunteers.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(volunteers);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/all-committees")
    public ResponseEntity<?> getCommittees() {
        try {
            List<Committee> committees = committeeService.getAllCommittees();
            if (committees.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(committees);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-activity")
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        try {
            Activity activity1 = activityService.saveActivity(activity);
            return ResponseEntity.status(201).body(activity1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-volunteer")
    public ResponseEntity<?> createVolunteer(@RequestBody Volunteer volunteer) {
        try {
            Volunteer volunteer1 = volunteerService.saveVolunteer(volunteer);
            return ResponseEntity.status(201).body(volunteer1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-training")
    public ResponseEntity<?> createTraining(@RequestBody Training training) {
        try {
            Training training1 = trainingService.saveTrain(training);
            return ResponseEntity.status(201).body(training1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-evaluation")
    public ResponseEntity<?> createEvaluation(@RequestBody Evaluation evaluation) {
        try {
            Evaluation evaluation1 = evaluationService.saveEvaluation(evaluation);
            return ResponseEntity.status(201).body(evaluation1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("new-task")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            Task task1 = taskService.saveTask(task);
            return ResponseEntity.status(201).body(task1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-committee")
    public ResponseEntity<?> createCommittee(@RequestBody Committee committee) {
        try {
            Committee committee1 = committeeService.saveCommittee(committee);
            return ResponseEntity.status(201).body(committee1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/new-notification")
    public ResponseEntity<?> createNotification(@RequestBody Notification notification) {
        try {
            Notification notification1 = notificationService.saveNotification(notification);
            return ResponseEntity.status(201).body(notification1);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @PutMapping("/{id}/task")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task taskToUpdate = taskService.getTaskById(id);
            taskToUpdate.setStatus(task.getStatus());
            taskService.saveTask(taskToUpdate);
            return ResponseEntity.ok(taskToUpdate);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
