<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-07-28
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
  String test = "test Page String";
  String test2 = " test page 2 String out";
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>First Test h2<%= test%></h2>
  <p>
    <%
      out.println(test + test2 +"susseceful Print test");
    %>
  </p>
  </body>
</html>
