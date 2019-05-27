package com.mitrais.rms.controller;

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

@WebServlet("/edit")
public class EditServlet extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.find(id).get();

        req.setAttribute("user", user);

        System.out.println(id);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/users/edit.jsp");
        rd.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.find(id).get();

        System.out.println("OLD: " + user.getId() + " - " + user.getUserName() + " - " + user.getPassword());

        String newUsername = req.getParameter("username");
        String newPassword = req.getParameter("userpass");

        user.setUserName(newUsername);
        user.setPassword(newPassword);
        System.out.println("NEW: " + user.getId() + " - " + user.getUserName() + " - " + user.getPassword());

//        User updateuser = new User(id, newUsername, newPassword);
//        System.out.println(updateuser.getId() + " " + updateuser.getUserName() + " " + updateuser.getPassword());
        userDao.update(user);
//        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/users/list.jsp");
//        rd.forward(req, resp);
//        resp.sendRedirect("users");
    }
}
