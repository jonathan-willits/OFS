<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 4/28/24
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath());
%>