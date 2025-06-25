package com.vho.activ.service;

import com.vho.activ.models.Activity;
import com.vho.activ.repo.ActivityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityService {

    private ActivityRepo activityRepo;

    public Activity saveActivity(Activity event) {
        return activityRepo.save(event);
    }
    public Activity getActivityById(long id) {
        return activityRepo.findById(id).get();
    }
    public List<Activity> getAllActivitiesByCommitteeId(long committeeId) {
        return activityRepo.findActivitiesByCommittee_commId(committeeId);
    }
}
