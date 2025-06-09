package com.vho.activ.repo;

import com.vho.activ.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface VolunteerRepo extends JpaRepository <Volunteer, UUID> {
}

