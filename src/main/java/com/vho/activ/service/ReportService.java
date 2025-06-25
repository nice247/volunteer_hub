package com.vho.activ.service;

import com.vho.activ.models.Report;
import com.vho.activ.repo.ReportRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {
    private ReportRepo reportRepo;

    public Report saveReport(Report report) {
        return reportRepo.save(report);
    }
    public Report getReportById(Long id) {
        return reportRepo.findById(id).orElse(null);
    }
    public Report getReportByReporterId(Long reporterId) {
        return reportRepo.findReportByReporter_volId(reporterId);
    }
    public List<Report> getReportsByCommitteeId(Long committeeId) {
        return reportRepo.findReportsByCommittee_commId(committeeId);
    }
}
