package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACTIVITIES")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Committee committee;

    private String reason;
    private String actName;
    private String actType;
    private String locationName;
    private LocalDate actDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
