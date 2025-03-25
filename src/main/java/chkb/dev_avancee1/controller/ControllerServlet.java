package chkb.dev_avancee1.controller;

import java.io.*;

import chkb.dev_avancee1.model.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "controllerServlet", urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath().substring(1);
        HttpSession session = request.getSession();

        switch (action) {
            case "login.do":
                handleLogin(request, response, session);
                break;
            case "updateAttributes.do":
                handleUpdateAttributes(request, response, session);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath().substring(1);
        HttpSession session = request.getSession();

        switch (action) {
            case "start.do":
                handleStart(request, response, session);
                break;
            case "logout.do":
                handleLogout(request, response, session);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            UserBean user = new UserBean();
            user.setNom(username);
            user.setAttribut1("default1");
            user.setAttribut2("default2");

            session.setAttribute("user", user);
            response.sendRedirect("page1.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void handleUpdateAttributes(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            String attribut1 = request.getParameter("attribut1");
            String attribut2 = request.getParameter("attribut2");

            user.setAttribut1(attribut1);
            user.setAttribut2(attribut2);

            session.setAttribute("user", user);
        }

        response.sendRedirect("page1.jsp");
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        session.invalidate();
        response.sendRedirect("goodbye.jsp");
    }

    private void handleStart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.sendRedirect("login.jsp");
    }
}