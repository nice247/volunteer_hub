package com.vho.activ.repo;

import com.vho.activ.models.Apology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApologyRepo extends JpaRepository<Apology, Long> {
    List<Apology> findApologiesByVolunteer_VolId(Long volId);
    List<Apology> findApologiesByActivity_ActId(Long activityActId);
}
