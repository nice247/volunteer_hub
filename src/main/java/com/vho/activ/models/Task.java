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
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Committee committee;

    @ManyToOne
    @JoinColumn(name = "assignedTo")
    private Volunteer assignedTo;

    private String description;
    private LocalDate deadline;
    private String status;
}
