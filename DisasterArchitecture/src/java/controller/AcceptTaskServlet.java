package controller;

import model.User;
import service.ReportService;
import service.TaskService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AcceptTaskServlet")
public class AcceptTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");

        // Check if user is logged in
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Only volunteers can accept tasks
        if (!user.getRole().equals("Volunteer")) {
            response.sendRedirect("home.jsp");
            return;
        }

        int taskId = Integer.parseInt(request.getParameter("taskId"));

        TaskService taskService = new TaskService();

        // Accept the task
        taskService.acceptTask(taskId, user.getUserId());

        // Get the report ID for this task
        int reportId = taskService.getReportIdByTaskId(taskId);

        // Update report status
        ReportService reportService = new ReportService();
        reportService.updateReportStatus(reportId, "In Progress");

        // Go back to task list
        response.sendRedirect("ViewTaskServlet");
    }
}