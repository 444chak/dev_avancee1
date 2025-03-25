package chkb.dev_avancee1;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // For demonstration purposes, we will use hardcoded credentials
        if ("admin".equals(username) && "password".equals(password)) {
            UserBean user = new UserBean();
            user.setNom(username);
            user.setAttribut1("default1");
            user.setAttribut2("default2");

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect to a welcome page or another servlet
            response.sendRedirect("page1.jsp");
        } else {
            // Redirect back to the login page with an error message
            response.sendRedirect("error.jsp");
        }
    }
}