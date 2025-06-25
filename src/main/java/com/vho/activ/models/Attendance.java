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
@Table(name = "ATTENDANCE")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name = "volId")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "actId")
    private Activity activity;

    private LocalDateTime checkIn;
    private String status;
    private LocalDateTime checkOut;
    private int totalMin;

    @Transient
    public String getDurationFormated() {
        int hours = totalMin / 60;
        int remainder = totalMin % 60;

        if (hours > 0)
            return hours + " hours " + remainder + " remainder";
        return remainder + " remainder";
    }

}
