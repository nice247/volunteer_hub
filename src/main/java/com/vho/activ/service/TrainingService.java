package com.vho.activ.service;


import com.vho.activ.models.Training;
import com.vho.activ.repo.TrainingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {

    private TrainingRepo trainingRepo;

    public Training saveTrain(Training training) {
        return trainingRepo.save(training);
    }
    public List<Training> getAllTrainingByVolunteerId(long volunteerId) {
        return trainingRepo.findTrainingsByVolunteer_VolId(volunteerId);
    }
    public List<Training> getAllTrainingByCommittee_CommId(long committeeId) {
        return trainingRepo.findTrainingsByCommittee_CommId(committeeId);
    }


}
