package chkb.dev_avancee1.action;

import chkb.dev_avancee1.model.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            UserBean user = new UserBean();
            user.setNom(username);
            user.setAttribut1("default1");
            user.setAttribut2("default2");

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "page1.jsp";
        } else {
            return "error.jsp";
        }
    }
}