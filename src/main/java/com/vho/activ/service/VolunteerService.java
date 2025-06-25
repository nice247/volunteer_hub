package com.vho.activ.service;

import com.vho.activ.models.Volunteer;
import com.vho.activ.repo.VolunteerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VolunteerService {
    private VolunteerRepo volunteerRepo;


    public Volunteer saveVolunteer(Volunteer volunteer) {
       return volunteerRepo.save(volunteer);
    }
    public List<Volunteer> getByCommitteeId(Long committeeId) {
        return volunteerRepo.findVolunteersByCommittee_commId(committeeId);
    }
    public Volunteer getVolunteerById(Long id) {
        return volunteerRepo.findById(id).get();
    }
}
