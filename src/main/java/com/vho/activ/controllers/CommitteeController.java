package com.vho.activ.controllers;

import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
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
    public Committee getCommitteeById(@PathVariable Long id) {
        return committeeService.getCommitteeById(id);
    }
    @GetMapping("/{name}")
    public Committee getCommitteeByName(@PathVariable String name) {
        return committeeService.getCommitteeByName(name);
    }
    @GetMapping("/{id}/tasks")
    public List<Task> getTasksByCommittee(@PathVariable Long id) {
        return taskService.getAllTasksByCommitteeId(id);
    }
    @GetMapping("/{id}/attendances")
    public List<Attendance> getAttendancesByCommittee(@PathVariable Long id) {
        return attendanceService.getAttendanceByCommitteeId(id);
    }
    @GetMapping("/{id}/evaluations")
    public List<Evaluation> getEvaluationsByCommitteeId(@PathVariable Long id) {
        return evaluationService.getEvaluationsByCommitteeId(id);
    }
    @GetMapping("/{id}/trainings")
    public List<Training> getTrainingsByCommitteeId(@PathVariable Long id) {
        return trainingService.getAllTrainingByCommittee_CommId(id);
    }
    @GetMapping("/{id}/reports")
    public List<Report> getReportsByCommitteeId(@PathVariable Long id) {
        return reportService.getReportsByCommitteeId(id);
    }
    @GetMapping("/{id}/apologies")
    public List<Apology> getApologiesByVolunteerId(@PathVariable Long id) {
        return apolygonService.getAllApologiesByVolunteerId(id);
    }

}
