package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RenameServlet")
public class RenameFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getParameter("newUsername")!=null && !req.getParameter("newUsername").equals("")){
            chain.doFilter(req,res);
        } else {
            res.getWriter().println("Invalid data");
        }
    }
}
