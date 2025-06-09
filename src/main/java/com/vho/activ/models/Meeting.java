package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String location;
    private String recurrence;

    @ManyToOne
    @JoinColumn(name = "committee_id")
    private Committee committee;

    @OneToMany(mappedBy = "meeting")
    private List<Attendance> attendances;

}