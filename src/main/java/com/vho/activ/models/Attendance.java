package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void calculateAttendance(LocalDateTime checkInTime, LocalDateTime checkOutTime) {

        if (this.checkInTime.isBefore(checkInTime) || this.checkInTime.isAfter(checkInTime.plusMinutes(15)) || this.checkInTime.isEqual(checkInTime)) {
            status = Status.ON_TIME;
        } else if (this.checkInTime.isAfter(checkInTime.plusMinutes(17))) {
            status = Status.LATER;
        }
        else status = Status.ABSENT;

    }
}