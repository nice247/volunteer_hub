package com.vho.activ.repo;

import com.vho.activ.models.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeRepo extends JpaRepository<Committee, Long> {
    Committee findCommitteeByName(String name);
}
