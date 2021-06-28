package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.CalcService;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    UserService userService = new UserService();
    CalcService calcService  = new CalcService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        calcService.deleteByUser(user);
        userService.deleteUser(user);
        req.getSession().invalidate();
        resp.getWriter().println("Account and all recordings have been deleted successfully");
    }
}
