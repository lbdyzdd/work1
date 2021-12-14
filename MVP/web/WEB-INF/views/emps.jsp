<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/13 0013
  Time: 上午 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EMPS</title>
</head>
<body>
    <h3>Welcome ${sessionScope.current_user.username}</h3>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>月薪</td>
            <td>入职日期</td>
            <td>部门编号</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.sal}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.deptno}</td>
            <td>
                <a href="${pageContext.request.contextPath}/emp/delete?empno=${emp.empno}" onclick="return confirm('确认删除吗')">删除</a>
                <a href="${pageContext.request.contextPath}/emp/findById?empno=${emp.empno}">更新</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/router?path=emp_save">新增</a>
    <form action="${pageContext.request.contextPath}/emp/findById" method="post">
        <input type="number" name="empno" />
        <input type="submit" value="查询"/>
    </form>
    <a href="${pageContext.request.contextPath}/emp_qurey.jsp">复杂查询</a>
</body>
</html>
