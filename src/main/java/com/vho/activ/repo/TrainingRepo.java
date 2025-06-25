package com.vho.activ.repo;

import com.vho.activ.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepo extends JpaRepository<Training, Long> {

    List<Training> findTrainingsByVolunteer_VolId(long volunteerId);
    List<Training> findTrainingsByCommittee_CommId(long committeeId);
}
