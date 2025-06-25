package com.vho.activ.repo;

import com.vho.activ.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report, Long> {

    List<Report> findReportsByCommittee_commId(Long commId);
    Report findReportByReporter_volId(Long volId);
}
