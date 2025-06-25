package com.vho.activ.controllers;
import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
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
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return volunteerService.getVolunteerById(id);
    }
    @GetMapping("/{id}/attends")
    public List<Attendance> getAttendanceByVolunteerId(@PathVariable Long id) {
        return attendanceService.getAttendanceByVolunteerId(id);
    }
    @GetMapping("/{id}/notify")
    public Notification getNotificationByRecipientId(@PathVariable Long id) {
        return notificationService.getNotificationByRecipientId(id);
    }
    @GetMapping("/{id}/trainings")
    public List<Training> getTrainingByVolunteerId(@PathVariable Long id) {
        return trainingService.getAllTrainingByVolunteerId(id);
    }
    @GetMapping("/{id}/task")
    public Task getTaskByVolunteerId(@PathVariable Long id) {
        return taskService.getTaskByAssignedTo(id);
    }
    @GetMapping("/{id}/evaluation")
    public Evaluation getEvaluationByVolunteerId(@PathVariable Long id) {
        return evaluationService.getEvaluationsByEvaluatedId(id);
    }
    @PostMapping("/apology")
    public Apology addApology(@RequestBody Apology apology) {
        return apologyService.saveApology(apology);
    }
    @PostMapping("/report")
    public Report addReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

}
