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
@Table(name = "VOLUNTEERS")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volId;

    private String fullName;
    private String email;
    private String phone;
    private String nationality;
    private String address;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Committee committee;

    private String role = "VOLUNTEER";
    private LocalDate regDate;
    private String status;
}