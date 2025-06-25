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
@Table(name = "TRAINING")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Committee committee;

    private String trainType;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "sourceEvalId")
    private Evaluation sourceEvaluation;

    private String notes;
    private String createdBy;
    private LocalDate createdDate;
}
