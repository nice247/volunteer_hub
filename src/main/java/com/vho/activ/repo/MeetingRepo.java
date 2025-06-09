package com.vho.activ.repo;

import com.vho.activ.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepo extends JpaRepository<Meeting, Long> {
    List<Meeting> findByCommitteeId(Long committeeId);
}
