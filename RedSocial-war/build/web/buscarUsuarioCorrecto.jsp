<%-- 
    Document   : buscarUsuarioCorrecto
    Created on : 11-may-2019, 13:29:22
    Author     : Rafa, Guillermo
--%>

<%@page import="java.util.List"%>
<%@page import="redsocial.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<String> us = (List) request.getAttribute("encontrados");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Email:
                </th>
            </tr>
        <%
            for(String u : us){
            %>  
            <tr>
                <td>
                    <%= u %>
                </td>
                <td>
                    <a href="">Visita su p&aacute;gina</a>
                </td>
            </tr>
        <%    }
            %>
        </table>
    </body>
</html>
