package service;

import dao.ReportDAO;
import model.Report;
import java.util.List;

public class ReportService {

    private ReportDAO reportDAO = new ReportDAO();

    // Submit report and return generated report ID
    public int submitReport(Report report) {

        return reportDAO.submitReport(report);

    }

    // View all reports
    public List<Report> getAllReports() {

        return reportDAO.getAllReports();

    }

    // View reports by user
    public List<Report> getReportsByUserId(int userId) {

        return reportDAO.getReportsByUserId(userId);

    }

    // Update report status
    public boolean updateReportStatus(int reportId, String status) {

        return reportDAO.updateReportStatus(reportId, status);

    }

}