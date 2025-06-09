package com.vho.activ.service;

import com.vho.activ.models.Committee;
import com.vho.activ.repo.CommitteeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeService {
    private final CommitteeRepo committeeRepo;

    public CommitteeService(CommitteeRepo committeeRepo) {
        this.committeeRepo = committeeRepo;
    }

    public Committee saveCommittee(Committee committee) {
        return committeeRepo.save(committee);
    }
    public Committee findCommitteeByName(String name) {
        return committeeRepo.findByName(name);
    }
    public Committee getCommitteeById(Long id) {
        return committeeRepo.findById(id).get();
    }
    public List<Committee> getAllCommittees() {
        return committeeRepo.findAll();
    }
}
