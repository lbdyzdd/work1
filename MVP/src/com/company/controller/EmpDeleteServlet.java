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
import java.io.IOException;

@WebServlet(urlPatterns = "/emp/delete")
public class EmpDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Integer empno = Integer.parseInt(request.getParameter("empno"));
      IEmpService empService = (IEmpService) ServiceFactory.getInstance(Const.EMP);
      Emp emp = new Emp();
      emp.setEmpno(empno);
      String msg = empService.delete(emp);
      if(Const.SUCCESS.equals(msg)){
          request.getRequestDispatcher("/emp/findAll").forward(request,response);
      }else{
          response.sendRedirect(request.getContextPath()+"/error.jsp");
      }
    }
}
