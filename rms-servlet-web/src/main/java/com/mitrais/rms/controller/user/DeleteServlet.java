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

@WebServlet("/delete")
public class DeleteServlet extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.find(id).orElse(null);

        boolean succeed = userDao.delete(user);

        if (!succeed) {
            req.getSession().setAttribute("message", "Fail deleting user");
        }

        req.getSession().setAttribute("message", "Succeed deleting user");
        resp.sendRedirect("/rms-servlet-web/users/list");
    }
}
