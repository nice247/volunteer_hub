package com.vho.activ.service;

import com.vho.activ.models.Apology;
import com.vho.activ.repo.ApologyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApologyService {

    private ApologyRepo apologyRepo;

    public Apology saveApology(Apology apology) {
        return apologyRepo.save(apology);
    }

    public List<Apology> getAllApologiesByVolunteerId(long volunteerId) {
        return apologyRepo.findApologiesByVolunteer_VolId(volunteerId);
    }
    public List<Apology> getAllApologiesByActivityId(long activityId) {
        return apologyRepo.findApologiesByActivity_ActId(activityId);
    }

    public List<Apology> getAllApologies() {
        return apologyRepo.findAll();
    }
}
