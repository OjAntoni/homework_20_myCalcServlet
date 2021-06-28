package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "PasswordServlet")
public class PasswordFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getParameter("newPassword")==null || req.getParameter("newPassword").equals("")){
            res.getWriter().println("Invalid new password");
        } else if(req.getParameter("oldPassword")==null || req.getParameter("oldPassword").equals("")){
            res.getWriter().println("Invalid old password");
        } else {
            chain.doFilter(req,res);
        }
    }
}

