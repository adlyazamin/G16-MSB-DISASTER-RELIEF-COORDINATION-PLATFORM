package controller;

import model.Resource;
import model.User;
import service.ResourceService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewResourceServlet")
public class ViewResourceServlet extends HttpServlet {

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

        ResourceService resourceService = new ResourceService();

        List<Resource> resources = resourceService.getAllResources();

        request.setAttribute("resources", resources);

        request.getRequestDispatcher("resources.jsp")
                .forward(request, response);

    }

}