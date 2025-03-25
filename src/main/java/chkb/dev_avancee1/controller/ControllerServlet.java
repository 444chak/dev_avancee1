package chkb.dev_avancee1.controller;

import chkb.dev_avancee1.ActionFactory;
import chkb.dev_avancee1.action.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "controllerServlet", urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionKey = request.getServletPath().substring(1);
        Action action = ActionFactory.getAction(actionKey);

        if (action != null) {
            String redirect = action.perform(request, response);
            response.sendRedirect(redirect);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}