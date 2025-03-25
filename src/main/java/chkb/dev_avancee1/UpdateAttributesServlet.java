package chkb.dev_avancee1;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "updateAttributesServlet", value = "/updateAttributesServlet")
public class UpdateAttributesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
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
}