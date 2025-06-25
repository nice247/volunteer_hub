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
@Table(name = "APOLOGY")
public class Apology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apoId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "actId")
    private Activity activity;

    private LocalDate apoDate;
    private String reason;
    private String status;
    private String response;
}
