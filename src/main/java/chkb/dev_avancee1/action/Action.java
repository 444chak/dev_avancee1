package chkb.dev_avancee1.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public interface Action {
    String perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}