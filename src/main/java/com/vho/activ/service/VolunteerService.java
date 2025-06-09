package com.vho.activ.service;

import com.vho.activ.models.Volunteer;
import com.vho.activ.repo.VolunteerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VolunteerService {
    private VolunteerRepo volunteerRepo;

    public VolunteerService(VolunteerRepo volunteerRepo) {
        this.volunteerRepo = volunteerRepo;
    }

    public Volunteer saveVolunteer(Volunteer volunteer) {
        return volunteerRepo.save(volunteer);
    }
    public List<Volunteer> getVolunteers() {
        return volunteerRepo.findAll();
    }
    public Volunteer getVolunteerById(UUID id) {
        return volunteerRepo.findById(id).get();
    }
}
