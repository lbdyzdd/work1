package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/find_id")
public class UserFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IUserService userService = (IUserService) ServiceFactory.getInstance(Const.USER);
        User user = userService.findById(id);
        if(user != null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/show_user.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
