package com.vho.activ.service;

import com.vho.activ.models.Task;
import com.vho.activ.repo.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepo taskRepo;

    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }
    public Task getTaskById(Long taskId) {
        return taskRepo.findById(taskId).orElse(null);
    }
    public Task getTaskByAssignedTo(Long volId) {
        return taskRepo.findTaskByAssignedTo_VolId(volId);
    }
    public List<Task> getAllTasksByCommitteeId(long committeeId) {
        return taskRepo.findTasksByCommittee_commId(committeeId);
    }
}
