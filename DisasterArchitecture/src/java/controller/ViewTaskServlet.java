package controller;

import model.Task;
import model.User;
import service.TaskService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewTaskServlet")
public class ViewTaskServlet extends HttpServlet {

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

        // Only volunteers can view tasks
        if (!user.getRole().equals("Volunteer")) {
            response.sendRedirect("home.jsp");
            return;
        }

        TaskService taskService = new TaskService();

        List<Task> tasks = taskService.getAvailableTasks();

        request.setAttribute("tasks", tasks);

        request.getRequestDispatcher("tasks.jsp")
                .forward(request, response);

    }

}