package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ILoginService loginService = (ILoginService) ServiceFactory.getInstance(Const.LOGIN);
        User user = loginService.login(username,password);
        HttpSession session = request.getSession();
        if(user != null){
            user.setPassword(null);
            session.setAttribute(Const.CURRENT_USER,user);
//            request.getRequestDispatcher("/emps").forward(request,response);
            request.getRequestDispatcher("/emp/findAll").forward(request,response);
        }else{
            session.setAttribute(Const.ERROR_MSG,"登录失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
