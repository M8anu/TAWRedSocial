<%-- 
    Document   : chats
    Created on : 08-may-2019, 19:53:06
    Author     : Guille
--%>

<%@page import="java.util.List"%>
<%@page import="redsocial.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Usuario> listaUsuarios = (List)request.getAttribute("listaUsuarios");
    Usuario us = (Usuario)request.getAttribute("us");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de chats</title>
    </head>
    <body>
        <h1>Lista de chats</h1>
        <table>
            <tr>
                <th>
                    Amigos
                </th>
            </tr>
            <%
                for (Usuario u: listaUsuarios) {
            %>
            <tr>
                <td>
                     <%=u.getNick() %>
                </td>
                <td>
                    <a href="individualServlet?id=<%=us.getIdUsuario()%>&id2=<%=u.getIdUsuario()%>"> Abrir chat </a>
                </td>
            </tr>
            
            <% } %>
        </table>
    </body>
</html>
