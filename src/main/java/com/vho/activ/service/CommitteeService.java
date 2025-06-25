package com.vho.activ.service;

import com.vho.activ.models.Committee;
import com.vho.activ.repo.CommitteeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommitteeService {
    private CommitteeRepo committeeRepo;

    public Committee saveCommittee(Committee committee) {
        return committeeRepo.save(committee);
    }
    public Committee getCommitteeByName(String name) {
        return committeeRepo.findCommitteeByName(name);
    }
    public Committee getCommitteeById(Long id) {
        return committeeRepo.findById(id).get();
    }
    public List<Committee> getAllCommittees() {
        return committeeRepo.findAll();
    }
}
