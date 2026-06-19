package controller;

import model.Report;
import model.User;
import service.ReportService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewReportServlet")
public class ViewReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        ReportService reportService = new ReportService();

        List<Report> reports;

        // Victim can only see their own reports
        if (user.getRole().equals("Victim")) {

            reports = reportService.getReportsByUserId(user.getUserId());

        }
        // Government and NGO can see all reports
        else if (user.getRole().equals("Government")
                || user.getRole().equals("NGO")) {

            reports = reportService.getAllReports();

        }
        // Volunteers should not access reports
        else {

            response.sendRedirect("home.jsp");
            return;

        }

        request.setAttribute("reports", reports);

        request.getRequestDispatcher("reports.jsp").forward(request, response);

    }

}