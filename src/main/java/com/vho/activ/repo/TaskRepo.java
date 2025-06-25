package com.vho.activ.repo;

import com.vho.activ.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findTasksByCommittee_commId(long committeeId);
    Task findTaskByAssignedTo_VolId(long volunteerId);
}
