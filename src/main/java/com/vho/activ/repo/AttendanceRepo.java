package com.vho.activ.repo;

import com.vho.activ.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
