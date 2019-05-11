<%-- 
    Document   : a
    Created on : 11-may-2019, 1:12:24
    Author     : Guille
--%>

<%@page import="redsocial.entity.Usuario"%>
<%@page import="redsocial.entity.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String id = (String)request.getAttribute("id");
    String id2 = (String)request.getAttribute("id2");
    %>
    

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mensaje enviado correctamente </h1>
        <form action="individualServlet">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="id2" value="<%=id2%>">
            <button>Seguir en chat</button>
        </form>
        <form action="ChatsServlet">
            <input type="hidden" name="id" value="<%=id%>">
            <button>Volver a lista de chats</button>
        </form>
    </body>
</html>
