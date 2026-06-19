package dao;

import model.Report;
import util.ReportDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    // Submit report and return generated report ID
    public int submitReport(Report report) {

        String sql = "INSERT INTO reports(user_id, disaster_type, description, location, risk_level, status) VALUES(?,?,?,?,?,?)";

        try {

            Connection conn = ReportDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, report.getUserId());
            ps.setString(2, report.getDisasterType());
            ps.setString(3, report.getDescription());
            ps.setString(4, report.getLocation());
            ps.setString(5, report.getRiskLevel());
            ps.setString(6, report.getStatus());

            int row = ps.executeUpdate();

            if (row > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return -1;
    }

    // View all reports
    public List<Report> getAllReports() {

        List<Report> reportList = new ArrayList<>();

        String sql = "SELECT * FROM reports ORDER BY report_id DESC";

        try {

            Connection conn = ReportDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Report report = new Report();

                report.setReportId(rs.getInt("report_id"));
                report.setUserId(rs.getInt("user_id"));
                report.setDisasterType(rs.getString("disaster_type"));
                report.setDescription(rs.getString("description"));
                report.setLocation(rs.getString("location"));
                report.setRiskLevel(rs.getString("risk_level"));
                report.setStatus(rs.getString("status"));

                reportList.add(report);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return reportList;
    }
public boolean updateReportStatus(int reportId, String status){

    String sql = "UPDATE reports SET status=? WHERE report_id=?";

    try{

        Connection conn = ReportDBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, reportId);

        int row = ps.executeUpdate();

        return row > 0;

    }catch(SQLException e){

        e.printStackTrace();

    }

    return false;

}

// View reports by user
public List<Report> getReportsByUserId(int userId) {

    List<Report> reportList = new ArrayList<>();

    String sql = "SELECT * FROM reports WHERE user_id=? ORDER BY report_id DESC";

    try {

        Connection conn = ReportDBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Report report = new Report();

            report.setReportId(rs.getInt("report_id"));
            report.setUserId(rs.getInt("user_id"));
            report.setDisasterType(rs.getString("disaster_type"));
            report.setDescription(rs.getString("description"));
            report.setLocation(rs.getString("location"));
            report.setRiskLevel(rs.getString("risk_level"));
            report.setStatus(rs.getString("status"));

            reportList.add(report);

        }

    } catch (SQLException e) {

        e.printStackTrace();

    }

    return reportList;

}

}

