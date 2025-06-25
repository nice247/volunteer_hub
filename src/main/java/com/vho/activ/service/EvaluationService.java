package com.vho.activ.service;

import com.vho.activ.models.Evaluation;
import com.vho.activ.repo.EvaluationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EvaluationService {

    private EvaluationRepo evaluationRepo;

    public Evaluation saveEvaluation(Evaluation evaluation) {
        return evaluationRepo.save(evaluation);
    }
    public Evaluation getEvaluationsByEvaluatedId(Long evaluatedId) {
        return evaluationRepo.findEvaluationByEvaluated_VolId(evaluatedId);
    }
    public List<Evaluation> getEvaluationsByCommitteeId(Long committeeId) {
        return evaluationRepo.findEvaluationsByEvaluator_Committee_CommId(committeeId);
    }
    public List<Evaluation> getEvaluationsByEvaluatorId(Long evaluatorId) {
        return evaluationRepo.findEvaluationsByEvaluator_VolId(evaluatorId);
    }
}
