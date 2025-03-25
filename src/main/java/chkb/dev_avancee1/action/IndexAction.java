package chkb.dev_avancee1.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index.jsp";
    }
}