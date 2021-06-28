package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RenameServlet", urlPatterns = "/rename")
public class RenameServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String newUsername = req.getParameter("newUsername");
        userService.renameUser(user,newUsername);
    }
}
