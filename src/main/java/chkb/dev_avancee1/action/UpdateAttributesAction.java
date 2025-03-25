package chkb.dev_avancee1.action;

import chkb.dev_avancee1.model.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateAttributesAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            String attribut1 = request.getParameter("attribut1");
            String attribut2 = request.getParameter("attribut2");

            user.setAttribut1(attribut1);
            user.setAttribut2(attribut2);

            session.setAttribute("user", user);
        }

        return "page1.jsp";
    }
}