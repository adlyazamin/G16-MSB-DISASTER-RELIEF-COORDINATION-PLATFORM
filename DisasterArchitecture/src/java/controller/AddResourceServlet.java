package controller;

import model.Resource;
import model.User;

import service.ResourceService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddResourceServlet")
public class AddResourceServlet extends HttpServlet {

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

        Resource resource = new Resource();

        resource.setResourceName(request.getParameter("resourceName"));
        resource.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        resource.setLocation(request.getParameter("location"));
        resource.setStatus(request.getParameter("status"));

        ResourceService resourceService = new ResourceService();

        boolean success = resourceService.addResource(resource);

        if (success) {

            response.sendRedirect("ViewResourceServlet");

        } else {

            response.getWriter().println("Failed to add resource.");

        }

    }

}
