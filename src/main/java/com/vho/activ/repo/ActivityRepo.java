package com.vho.activ.repo;

import com.vho.activ.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
    List<Activity> findActivitiesByCommittee_commId(Long committeeId);
}
