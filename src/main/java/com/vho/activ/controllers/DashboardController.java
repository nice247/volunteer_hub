package com.vho.activ.controllers;

import com.vho.activ.models.*;
import com.vho.activ.service.*;
import lombok.AllArgsConstructor;
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
    public List<Evaluation> getEvaluationsByEvaluator(@PathVariable Long id) {
        return evaluationService.getEvaluationsByEvaluatorId(id);
    }
    @GetMapping("/{id}/report")
    public Report getReportByReporterId(@PathVariable Long id) {
        return reportService.getReportByReporterId(id);
    }
    @GetMapping("/report/{id}")
    public Report getReportByReportId(@PathVariable Long id) {
        return reportService.getReportById(id);
    }
    @GetMapping("/{id}/volunteers")
    public List<Volunteer> getVolunteersByCommitteeId(@PathVariable Long id) {
        return volunteerService.getByCommitteeId(id);
    }
    @GetMapping("/all-committees")
    public List<Committee> getCommittees() {
        return committeeService.getAllCommittees();
    }
    @PostMapping("/new-activity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }
    @PostMapping("/new-volunteer")
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.saveVolunteer(volunteer);
    }
    @PostMapping("/new-training")
    public Training createTraining(@RequestBody Training training) {
        return trainingService.saveTrain(training);
    }
    @PostMapping("/new-evaluation")
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.saveEvaluation(evaluation);
    }
    @PostMapping("new-task")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @PostMapping("/new-committee")
    public Committee addCommittee(@RequestBody Committee committee) {
        return committeeService.saveCommittee(committee);
    }
    @PostMapping("/new-notification")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.saveNotification(notification);
    }
    @PutMapping("/{id}/task")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task taskToUpdate = taskService.getTaskById(id);
        taskToUpdate.setStatus(task.getStatus());
        return taskService.saveTask(taskToUpdate);
    }
}
