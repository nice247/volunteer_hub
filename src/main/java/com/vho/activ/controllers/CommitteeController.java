package com.vho.activ.controllers;

import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/committees")
@AllArgsConstructor
public class CommitteeController {

    private CommitteeService committeeService;
    private TrainingService trainingService;
    private EvaluationService evaluationService;
    private TaskService taskService;
    private ReportService reportService;
    private AttendanceService attendanceService;
    private ApologyService apolygonService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommitteeById(@PathVariable Long id) {
        try {
            Committee committee = committeeService.getCommitteeById(id);
            if (committee == null)
                return ResponseEntity.status(404).body("Committee not found");
            return ResponseEntity.ok(committee);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCommitteeByName(@PathVariable String name) {
        try {
            Committee committee = committeeService.getCommitteeByName(name);
            if (committee == null)
                return ResponseEntity.status(404).body("Committee not found");
            return ResponseEntity.ok(committee);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<?> getTasksByCommittee(@PathVariable Long id) {
        try {
            List<Task> tasks = taskService.getAllTasksByCommitteeId(id);
            if (tasks.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/attendances")
    public ResponseEntity<?> getAttendancesByCommittee(@PathVariable Long id) {
        try {
            List<Attendance> attendances = attendanceService.getAttendanceByCommitteeId(id);
            if (attendances.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(attendances);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/{id}/evaluations")
    public ResponseEntity<?> getEvaluationsByCommitteeId(@PathVariable Long id) {
        try {
            List<Evaluation> evaluations = evaluationService.getEvaluationsByCommitteeId(id);
            if (evaluations.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(evaluations);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/trainings")
    public ResponseEntity<?> getTrainingsByCommitteeId(@PathVariable Long id) {
        try {
            List<Training> trainings = trainingService.getAllTrainingByCommittee_CommId(id);
            if (trainings.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(trainings);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/reports")
    public ResponseEntity<?> getReportsByCommitteeId(@PathVariable Long id) {
        try {
            List<Report> reports = reportService.getReportsByCommitteeId(id);
            if (reports.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/{id}/apologies")
    public ResponseEntity<?> getApologiesByVolunteerId(@PathVariable Long id) {
        try {
            List<Apology> apologies = apolygonService.getAllApologiesByVolunteerId(id);
            if (apologies.isEmpty())
                return ResponseEntity.status(204).build();
            return ResponseEntity.ok(apologies);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

}
