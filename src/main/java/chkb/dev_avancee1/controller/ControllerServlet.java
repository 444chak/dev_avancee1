package chkb.dev_avancee1.controller;

import chkb.dev_avancee1.action.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "controllerServlet", urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet {
    private Map<String, Action> actions = new HashMap<>();

    @Override
    public void init() {
        actions.put("login.do", new LoginAction());
        actions.put("logout.do", new LogoutAction());
        actions.put("updateAttributes.do", new UpdateAttributesAction());
        actions.put("start.do", new StartAction());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionKey = request.getServletPath().substring(1);
        Action action = actions.get(actionKey);

        if (action != null) {
            String redirect = action.perform(request, response);
            response.sendRedirect(redirect);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}