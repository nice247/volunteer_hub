package com.vho.activ.repo;

import com.vho.activ.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findEvaluationsByEvaluator_VolId(Long vhoId);
    List<Evaluation> findEvaluationsByEvaluator_Committee_CommId(Long committeeId);
    Evaluation findEvaluationByEvaluated_VolId(Long vhoId);

    Evaluation findEvaluationByTask_TaskId(Long taskId);


}
