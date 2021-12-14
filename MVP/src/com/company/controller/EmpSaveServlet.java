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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/emp/empSave")
public class EmpSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));
        Date hiredate = null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        Emp newEmp = new Emp(ename,sal,hiredate,deptno);
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Const.EMP);
        String msg = empService.save(newEmp);
        if(Const.SUCCESS.equals(msg)){
            request.getRequestDispatcher("/emp/findAll").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
