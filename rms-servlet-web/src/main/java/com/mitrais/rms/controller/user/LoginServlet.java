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

@WebServlet("/login")
public class LoginServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");

        if (checkLogin(username,userpass)) {
            resp.sendRedirect("/rms-servlet-web/users");
        } else {
            req.getSession().setAttribute("errorMessage", "Invalidate user");
            System.out.println("INVALIDATE");
            RequestDispatcher rd = req.getRequestDispatcher(getTemplatePath("/login"));
            rd.forward(req, resp);
        }
    }

    private boolean checkLogin (String username, String userpass) {
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.findByUserName(username).get();

        if (user.getUserName().equals(username) && user.getPassword().equals(userpass)) {
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            return true;
        }
        return false;
    }
}
