package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private String nationality;
    private String address;

    @ManyToOne
    @JoinColumn(name = "committee_id")
    private Committee committee;

    @Enumerated(EnumType.STRING)
    Role role = Role.VOLUNTEER;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

}