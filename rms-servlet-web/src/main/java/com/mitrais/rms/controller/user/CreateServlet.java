package com.mitrais.rms.controller.user;

import com.mitrais.rms.controller.AbstractController;
import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String path = getTemplatePath("/users" + req.getServletPath());
        String path = getTemplatePath("/users/form");
        System.out.println(path);

        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUserName = req.getParameter("username");
        String newUserPass = req.getParameter("userpass");

        System.out.println("uname: " + newUserName + "    " + "upass: " + newUserPass);

        UserDao userDao = UserDaoImpl.getInstance();
        boolean succeed = userDao.save(new User(newUserName, newUserPass));
        System.out.println(succeed);

        if(!succeed){
            req.getSession().setAttribute("message", "Fail create user");
        }

        req.getSession().setAttribute("message", "Succeed create user");
        resp.sendRedirect("/rms-servlet-web/users/list");
    }
}
