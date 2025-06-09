package com.vho.activ.repo;

import com.vho.activ.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByCommitteeId(Long committeeId);
}
