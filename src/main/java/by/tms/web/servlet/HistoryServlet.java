package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalcService;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HistoryServlet", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
    CalcService calcService = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Operation> allByUser = calcService.findAllByUser(user);
        for (Operation operation : allByUser) {
            resp.getWriter().println(operation);
        }
    }
}
