package com.vho.activ.repo;

import com.vho.activ.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepo extends JpaRepository <Volunteer, Long> {

    List<Volunteer> findVolunteersByCommittee_commId(Long committeeId );
}

