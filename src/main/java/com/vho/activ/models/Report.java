package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REPORT")
//This entity is intended to report a problem
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer reporter;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Committee committee;

    private String repType;
    private String description;
    private LocalDateTime repDate;
    private String status;
    private String resolution;
}
