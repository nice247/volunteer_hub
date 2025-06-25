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
@Table(name = "NOTIFICATION")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notifId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer recipient;

    private LocalDateTime notifDate;
    private String type;
    private String message;
}
