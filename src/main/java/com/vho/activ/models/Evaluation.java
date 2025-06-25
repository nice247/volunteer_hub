package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EVALUATIONS")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evalId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer evaluated;

    @ManyToOne
    @JoinColumn(name = "actId")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "evaluatorId")
    private Volunteer evaluator;

    private Double score;
    private String strengths;
    private String improvements;
    private LocalDate evalDate;
}
