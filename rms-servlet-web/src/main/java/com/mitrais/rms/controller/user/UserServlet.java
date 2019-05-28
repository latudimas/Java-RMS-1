package com.mitrais.rms.controller.user;

import com.mitrais.rms.controller.AbstractController;
import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String path = getTemplatePath(req.getServletPath() + req.getPathInfo());
        String path = getTemplatePath(req.getServletPath() + "/list");
        System.out.println(req.getServletPath());
//        System.out.println("templatePath: " + req.getServletPath() + "     ||| path info:" + req.getPathInfo() );

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);

        UserDao userDao = UserDaoImpl.getInstance();
        List<User> users = userDao.findAll();
        req.setAttribute("users", users);

        requestDispatcher.forward(req, resp);
    }
}
