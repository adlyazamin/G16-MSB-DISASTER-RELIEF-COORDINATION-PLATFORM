package controller;

import model.Notification;
import model.Report;
import model.Task;
import model.User;

import service.NotificationService;
import service.ReportService;
import service.TaskService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SubmitReportServlet")
public class SubmitReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Report report = new Report();

        report.setUserId(user.getUserId());
        report.setDisasterType(request.getParameter("disasterType"));
        report.setDescription(request.getParameter("description"));
        report.setLocation(request.getParameter("location"));
        report.setRiskLevel(request.getParameter("riskLevel"));
        report.setStatus("Pending");

        ReportService reportService = new ReportService();

        int reportId = reportService.submitReport(report);

        if (reportId != -1) {

            // If High Risk, automatically create a volunteer task
            if (report.getRiskLevel().equalsIgnoreCase("High")) {

                // Create volunteer task
                Task task = new Task();

                task.setReportId(reportId);
                task.setTaskDescription(
                        report.getDisasterType() + " at " + report.getLocation()
                );

                TaskService taskService = new TaskService();

                taskService.createTask(task);

                // Create notification
                Notification notification = new Notification();

                notification.setUserId(user.getUserId());
                notification.setMessage(
                        "High Risk " + report.getDisasterType()
                        + " reported at " + report.getLocation()
                );
                notification.setNotificationType("Emergency");
                notification.setStatus("Sent");

                NotificationService notificationService = new NotificationService();

                notificationService.createNotification(notification);
            }

            response.sendRedirect("ViewReportServlet");

        } else {

            response.getWriter().println("Failed to submit report.");

        }

    }

}