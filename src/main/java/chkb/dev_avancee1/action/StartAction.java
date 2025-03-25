package chkb.dev_avancee1.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StartAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        return "login.jsp";
    }
}