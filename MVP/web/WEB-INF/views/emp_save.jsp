<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/13 0013
  Time: 下午 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增一名员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/empSave" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="ename"/> </td>
        </tr>
        <tr>
            <td>工资</td>
            <td><input type="number" name="sal"/> </td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><input type="date" name="hiredate"/> </td>
        </tr>
        <tr>
            <td>部门编号</td>
            <td><input type="number" name="deptno"/> </td>
        </tr>
        <tr>
            <td><input type="submit" value="新增"/></td>
            <td><input type="reset" value="重置"/> </td>
        </tr>
    </table>
</form>
</body>
</html>
