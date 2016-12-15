<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 12/14/2016
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("view.jsp");
%>
<html>
<head>
    <title>Simple MVC</title>
</head>
<body>
    <p>counter</p>
    <p><%=request.getAttribute("counter")%></p>
    <form method="post" action="<%=request.getContextPath()%>/counter">
        <p><input type="button" value="PressMe"/></p>
    </form>
</body>
</html>