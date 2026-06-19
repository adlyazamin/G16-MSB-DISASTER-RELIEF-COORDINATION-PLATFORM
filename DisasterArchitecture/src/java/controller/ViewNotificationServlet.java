package controller;

import model.Notification;
import model.User;
import service.NotificationService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewNotificationServlet")
public class ViewNotificationServlet extends HttpServlet {

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

        // Only Government and NGO can view notifications
        if (!user.getRole().equals("Government")
                && !user.getRole().equals("NGO")) {

            response.sendRedirect("home.jsp");
            return;

        }

        NotificationService notificationService = new NotificationService();

        List<Notification> notifications = notificationService.getAllNotifications();

        request.setAttribute("notifications", notifications);

        request.getRequestDispatcher("notifications.jsp").forward(request, response);

    }

}