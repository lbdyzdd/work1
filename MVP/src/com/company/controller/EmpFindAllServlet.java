package com.company.controller;

import com.company.comm.Const;
import com.company.dao.entity.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/emp/findAll")
public class EmpFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            IEmpService empService = (IEmpService) ServiceFactory.getInstance(Const.EMP);
            List<Emp> emps = empService.findAll();
            request.setAttribute("emps", emps);
            request.getRequestDispatcher("/WEB-INF/views/emps.jsp").forward(request, response);

    }
}
